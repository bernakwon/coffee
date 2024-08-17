package com.dream.coffee.domain.info.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderSaveRequestParam {
   // 유저,메뉴,카페,파티
    private Long userId;
    private Long menuId;
    private Long cafeId;
    private Long partyId;
    @Schema(description = "직접입력메뉴")
    private String directMenu;//직접입력

}


