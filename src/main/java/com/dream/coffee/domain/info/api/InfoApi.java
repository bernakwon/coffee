package com.dream.coffee.domain.info.api;

import com.dream.coffee.domain.info.dto.OrderStatusResponse;
import com.dream.coffee.domain.info.dto.PartyDtlInfoResponse;
import com.dream.coffee.domain.info.dto.UserResponse;
import com.dream.coffee.domain.info.entity.Cafe;
import com.dream.coffee.domain.info.service.cafe.CafeService;
import com.dream.coffee.domain.info.service.party.PartyService;
import com.dream.coffee.domain.info.service.users.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class InfoApi {

    private final UserService userService;
    private final CafeService cafeService;

    private final PartyService partyService;
    @GetMapping("/users")
    public List<UserResponse> getList(){

        return userService.getAllUsers();
    }
    @GetMapping("/cafe/info")
    public List<Cafe> getCafeList(){
        return cafeService.getAllCafe();
    }

    @GetMapping("/party/info/{partyId}")
    public List<PartyDtlInfoResponse> getPartyList(@PathVariable("partyId") Long partyId){
        return partyService.getById(partyId);
    }

    @PostMapping("/order/status/{partyId}")
    public OrderStatusResponse getOrderStatusByParty(@PathVariable("partyId") Long partyId){
        return partyService.getOrderStatusByParty(partyId);
    }




}
