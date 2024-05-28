package com.dream.coffee.domain.info.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderMenuCountReponse {

    private String menuNm;
    private long orderCount;
    private Long menuId;

    public OrderMenuCountReponse(Long menuId, String menuNm) {
        this.menuNm = menuNm;
        this.menuId = menuId;
    }
}
