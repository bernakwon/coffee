package com.dream.coffee.domain.order.dto;

import lombok.Data;

@Data
public class OrderMenuCountResponse {
    private Long menuId;
    private String menuNm;



    public OrderMenuCountResponse(Long menuId, String menuNm) {
        this.menuId = menuId;
        this.menuNm = menuNm;
    }
}