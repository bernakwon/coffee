package com.dream.coffee.domain.order.service;

import com.dream.coffee.domain.info.dto.*;
import com.dream.coffee.domain.order.entity.Orders;

import java.util.List;

public interface OrderService {


    Orders save(OrderSaveRequestParam orderSaveRequestParam);

    List<MenuSelectGroupUserResponse> getMenuSelectUsers(MenuSelectUserRequestParam requestParam);

    OrderStatusResponse getOrderStatusByParty(Long partyId);

    List<PartyUserDetailsResponse> getUserDetailByParty(Long partyId);
}
