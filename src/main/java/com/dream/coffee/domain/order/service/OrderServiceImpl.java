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
        Orders newOrders = Orders.builder().cafeId(orderSaveRequestParam.getCafeId())
                .menuId(orderSaveRequestParam.getMenuId())
                .partyId(orderSaveRequestParam.getPartyId())
                .userId(orderSaveRequestParam.getUserId())
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
    public  List<OrderStatusResponse>  getOrderStatusByParty(Long partyId) {

        List<OrderPureInfo> pureData = orderRepository.findOrderStatusByPartyId(partyId);

        // Grouping the data
        List<OrderStatusResponse> responseList = pureData.stream()
                .collect(Collectors.groupingBy(i -> Arrays.asList(i.getPartyName(), i.getCafeNm(), i.getEndDt())))
                .entrySet().stream()
                .map(e -> {
                    String partyName = (String) e.getKey().get(0);
                    String cafeNm = (String) e.getKey().get(1);
                    LocalDateTime endDt = (LocalDateTime) e.getKey().get(2);
                    // 메뉴별 그룹화
                    Map<Long, List<OrderPureInfo>> menuGroup = e.getValue().stream()
                            .collect(Collectors.groupingBy(OrderPureInfo::getMenuId));

                    // 각 메뉴별 주문 수 계산 및 OrderMenuCountReponse 생성
                    Set<OrderMenuCountReponse> orderMenuInfoList = menuGroup.entrySet().stream()
                            .map(entry -> {
                                Long menuId = entry.getKey();
                                String menuName = entry.getValue().get(0).getMenuNm();
                                int orderCount = entry.getValue().size();
                                return new OrderMenuCountReponse(menuId, menuName, orderCount);
                            })
                            .collect(Collectors.toSet());

                    Long userCount = e.getValue().get(0).getUserCount();
                    Long drinkCount = e.getValue().get(0).getDrinkCount();
                    boolean orderState = endDt.isAfter(LocalDateTime.now());
                    // Placeholder values for other counts (you can implement specific logic if needed)
                    int orderUserCount = userCount.intValue();
                    Long orderTagerUserCount = partyAttendeeRepository.countAttendeesByPartyId(partyId);
                    int orderDrinkCount = drinkCount.intValue();
                    Long orderTagerDrinkCount = orderRepository.countOrdersByPartyAndAttendees(partyId);
                    return new OrderStatusResponse(
                            partyName,
                            cafeNm,
                           endDt.format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")),
                            orderUserCount,
                            orderTagerUserCount.intValue(),
                            orderDrinkCount,
                            orderTagerDrinkCount.intValue(),
                            orderState,
                            orderMenuInfoList
                    );
                })
                .collect(Collectors.toList());

        return responseList;
    }
}
