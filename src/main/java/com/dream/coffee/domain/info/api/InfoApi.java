package com.dream.coffee.domain.info.api;

import com.dream.coffee.domain.info.dto.*;
import com.dream.coffee.domain.info.entity.Cafe;
import com.dream.coffee.domain.info.entity.Menu;
import com.dream.coffee.domain.info.service.cafe.CafeService;
import com.dream.coffee.domain.info.service.menu.MenuService;
import com.dream.coffee.domain.info.service.party.PartyService;
import com.dream.coffee.domain.info.service.users.UserService;
import com.dream.coffee.domain.order.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class InfoApi {

    private final UserService userService;
    private final CafeService cafeService;
    private final OrderService orderService;
    private final MenuService menuService;

    private final PartyService partyService;
    @Operation(summary = "사용자 목록 조회")
    @GetMapping("/users")
    public List<UserResponse> getList(){

        return userService.getAllUsers();
    }
    @Operation(summary = "카페 목록 조회(페이징)")
    @GetMapping("/cafe/info")
    public List<Cafe> getCafeList(){

        return cafeService.getAllCafe();
    }

    @Operation(summary = "파티 목록 조회")
    @GetMapping("/party/info/{partyId}")
    public List<PartyDtlInfoResponse> getPartyList(@PathVariable("partyId") Long partyId){
        return partyService.getById(partyId);
    }

    @Operation(summary = "주문자 주문현황 조회")
    @GetMapping("/order/status/{partyId}")
    public OrderStatusResponse getOrderStatusByParty(@PathVariable("partyId") Long partyId){
        return orderService.getOrderStatusByParty(partyId);
    }

    @Operation(summary = "메뉴 선택한 사용자 목록 포함한 메뉴목록 조회(사용여부 확인 필요")
    @PostMapping("/order/users")
    public List<MenuSelectGroupUserResponse> getMenuSelectUsers(@RequestBody MenuSelectUserRequestParam requestParam){
        return orderService.getMenuSelectUsers(requestParam);
    }

    @Operation(summary = "파티별 메뉴목록 조회(페이징)")
    @GetMapping("/menu/info/{partyId}")
    public Page<MenuInfoResponse> getMenu(@PathVariable("partyId") String partyId,@RequestParam("page") int page,@RequestParam("searchTag")  String searchTag){

    return menuService.getMenus(partyId,page,searchTag);
    }

    @Operation(summary = "파티별 사용자목록(주문여부 포함) 조회")
    @GetMapping("/order/users/{partyId}")
    public List<PartyUserDetailsResponse> getUserDetailByParty(@PathVariable("partyId") Long partyId){
        return orderService.getUserDetailByParty(partyId);
    }
}
