package com.dream.coffee.domain.order.service;

import com.dream.coffee.domain.info.dto.*;
import com.dream.coffee.domain.info.repository.PartyAttendeeRepository;
import com.dream.coffee.domain.info.repository.UsersRepository;
import com.dream.coffee.domain.order.dto.OrderPureInfo;
import com.dream.coffee.domain.order.entity.Orders;
import com.dream.coffee.domain.order.repository.OrderRepository;
import com.dream.coffee.global.error.CommonException;
import com.dream.coffee.global.error.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final UsersRepository usersRepository;

    private final PartyAttendeeRepository partyAttendeeRepository;

    @Override
    public Orders save(OrderSaveRequestParam orderSaveRequestParam) {
        if (Objects.isNull(orderSaveRequestParam)) {
            throw new CommonException(ErrorCode.INVALID_PARAM);
        }
        Orders newOrders = Orders.builder()
                .cafeId(orderSaveRequestParam.getCafeId())
                .menuId(ObjectUtils.isEmpty(orderSaveRequestParam.getMenuId()) ? -1L : orderSaveRequestParam.getMenuId())
                .partyId(orderSaveRequestParam.getPartyId())
                .userId(orderSaveRequestParam.getUserId())
                .customMenu(orderSaveRequestParam.getCustomMenu())
                .build();


        return orderRepository.save(newOrders);
    }

    @Override
    public List<MenuSelectGroupUserResponse> getMenuSelectUsers(MenuSelectUserRequestParam requestParam) {
        Long menuId = requestParam.getMenuId();
        Long partyId = requestParam.getPartyId();

        List<MenuSelectUserResponse> list = orderRepository.getMenuSelectUsers(menuId,partyId);
        List<MenuSelectGroupUserResponse> response = list.stream()
                .collect(Collectors.groupingBy(i->Arrays.asList(i.getMenuId(),i.getMenuNm())))
                .entrySet().stream()
                .map(e -> new MenuSelectGroupUserResponse((String) e.getKey().get(0), (String) e.getKey().get(1),(long) e.getValue().size(),
                        e.getValue().stream().map(i -> new SelectUser(i.getUserNm(), i.getTelNo())).collect(Collectors.toSet())
                ))
                .collect(Collectors.toList());

        return response;
    }

    @Override
    public  OrderStatusResponse getOrderStatusByParty(Long partyId) {

        List<OrderPureInfo> pureData = orderRepository.findOrderStatusByPartyId(partyId);

        OrderStatusResponse response = pureData.stream()
                .collect(Collectors.groupingBy(i -> Arrays.asList(i.getPartyName(), i.getCafeNm(), i.getEndDt())))
                .entrySet().stream()
                .map(e -> {
                    String partyName = (String) e.getKey().get(0);
                    String cafeNm = (String) e.getKey().get(1);
                    LocalDateTime endDt = (LocalDateTime) e.getKey().get(2);
                    Map<Long, List<OrderPureInfo>> menuGroup = e.getValue().stream()
                            .collect(Collectors.groupingBy(
                                    order -> {
                                        Long menuId = order.getMenuId();
                                        return (menuId != null) ? menuId : -1L; // menuId가 null일 경우 기본값 -1L 사용
                                    }
                            ));

                    Set<OrderMenuCountReponse> orderMenuInfoList = new HashSet<>();


                    Long userCount = e.getValue().get(0).getUserCount();
                    Long drinkCount = e.getValue().get(0).getDrinkCount();
                    boolean orderState = endDt.isAfter(LocalDateTime.now());

                    // Placeholder values for other counts (you can implement specific logic if needed)
                    int orderUserCount = userCount.intValue();
                    Long orderTargetUserCount = partyAttendeeRepository.countAttendeesByPartyId(partyId,null);
                    int orderDrinkCount = drinkCount.intValue();
                    Long orderTargetDrinkCount = partyAttendeeRepository.countAttendeesByPartyIdNotMenuId(partyId,99L);

                    if(orderUserCount>0){
                        orderMenuInfoList = menuGroup.entrySet().stream()
                                .map(entry -> {
                                    Long menuId = entry.getKey();
                                    String menuName = entry.getValue().get(0).getMenuNm();
                                    int orderCount = entry.getValue().size();

                                    List<OrderedUserResponse> users = orderRepository.findUsersByPartyIdAndMenuId(partyId, menuId);

                                    return new OrderMenuCountReponse(menuId, menuName, orderCount, users);
                                })
                                .collect(Collectors.toSet());
                    }

                    return new OrderStatusResponse(
                            partyName,
                            cafeNm,
                            endDt.format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")),
                            orderUserCount,
                            orderTargetUserCount.intValue(),
                            orderDrinkCount,
                            orderTargetDrinkCount.intValue(),
                            orderState,
                            orderMenuInfoList
                    );
                })
                .findFirst()
                .orElse(null);

        return response;
    }

    @Override
    public List<PartyUserDetailsResponse> getUserDetailByParty(Long partyId) {


        List<MenuSelectUserByPartyResponse> list = orderRepository.getUsersByPartyIdWithOrderStatus(partyId);
        String partyName = list.isEmpty() ? "Unknown Party" : list.get(0).getPartyName();

        List<PartyUserDetailsResponse> response = list.stream()
                .collect(Collectors.groupingBy(MenuSelectUserByPartyResponse::getPartyId))
                .entrySet().stream()
                .map(e -> new PartyUserDetailsResponse(
                        e.getKey(),
                        partyName,
                        (long) e.getValue().size(),
                        e.getValue().stream()
                                .map(i -> new PartySelectUserResponse(
                                        i.getUserId(),
                                        i.getName(),
                                        i.getTeam(),
                                        i.getDepartment(),
                                        i.getRank(),
                                        i.isOrderComplete()))
                                .collect(Collectors.toSet())
                ))
                .collect(Collectors.toList());

        return response;
    }
}
