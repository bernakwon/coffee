package com.dream.coffee.domain.order.service;

import com.dream.coffee.domain.info.dto.*;
import com.dream.coffee.domain.info.repository.PartyAttendeeRepository;
import com.dream.coffee.domain.info.repository.UsersRepository;
import com.dream.coffee.domain.order.entity.Orders;
import com.dream.coffee.domain.order.repository.OrderRepository;
import com.dream.coffee.global.error.CommonException;
import com.dream.coffee.global.error.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
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
    public MenuSelectUserResponse getMenuSelectUsers(MenuSelectUserRequestParam requestParam) {
        Long menuId = requestParam.getMenuId();
        Long partyId = requestParam.getPartyId();

        List<MenuSelectUserResponse> list = orderRepository.getMenuSelectUsers(menuId,partyId);
        MenuSelectGroupUserResponse response =  list.stream()
                .collect(Collectors.groupingBy(i-> i.getMenuId())
                .entrySet().stream()
                .map(e -> new PartyDtlInfoResponse((Long) e.getKey().get(0), (String) e.getKey().get(1), (LocalDateTime) e.getKey().get(2),
                        e.getValue().stream().map(i -> new UserResponse(i.getUserId(), i.getName())).collect(Collectors.toSet())
                ))
                .collect(Collectors.toList());
        return null;
    }


}
