package com.dream.coffee.domain.info.api;

import com.dream.coffee.domain.info.dto.MenuSaveRequestParam;
import com.dream.coffee.domain.info.dto.OrderSaveRequestParam;
import com.dream.coffee.domain.info.dto.PartySaveRequestParam;
import com.dream.coffee.domain.info.dto.PartySaveResponse;
import com.dream.coffee.domain.info.service.menu.MenuService;
import com.dream.coffee.domain.info.service.party.PartyService;
import com.dream.coffee.domain.order.entity.Orders;
import com.dream.coffee.domain.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SaveApi {

    private final PartyService partyService;
    private final OrderService orderService;
    private final MenuService menuService;

    @PutMapping("/party/save")
    public PartySaveResponse saveParty(@RequestBody PartySaveRequestParam partySaveRequestParam){
        return partyService.save(partySaveRequestParam);
    }

//메뉴 선택 후 주문 저장, 유저,메뉴,카페,파티
    @PutMapping("/order/save")
    public Orders saveOrders(@RequestBody OrderSaveRequestParam orderSaveRequestParam){
        return orderService.save(orderSaveRequestParam);
    }

    @PutMapping("/menu/save")
    public Long saveOrders(@RequestBody MenuSaveRequestParam menuSaveRequestParam){
        return menuService.save(menuSaveRequestParam);
    }
}
