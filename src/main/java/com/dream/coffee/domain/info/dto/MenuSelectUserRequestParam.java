package com.dream.coffee.domain.info.dto;

import lombok.Getter;

@Getter
public class MenuSelectUserRequestParam {
    private Long cafeId;
    private Long menuId;
    private Long partyId;
}
