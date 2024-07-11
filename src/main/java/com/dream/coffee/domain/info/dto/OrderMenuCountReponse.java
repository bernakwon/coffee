package com.dream.coffee.domain.info.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderMenuCountReponse {



    private Long menuId;
    private String menuNm;
    private long orderCount;

    private List<OrderedUserResponse> ordererList;

}
