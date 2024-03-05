package com.dream.coffee.domain.info.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderStatusResponse {


    private String partyName;//파티명(party)
    private String cafeNm;//카페명(파티랑 조인 cafe)
    private String endDt;//(party)
    private int orderUserCount;
    private int orderTagerUserCount;
    private int orderDrinkCount;
    private int orderTagerDrinkCount;
    private int orderState;
    private List<OrderMenuCountReponse> orderMenuInfoList;
}
