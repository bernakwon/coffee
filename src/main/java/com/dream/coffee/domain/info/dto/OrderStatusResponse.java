package com.dream.coffee.domain.info.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderStatusResponse {


    private String partyName; // 파티명(party)
    private String cafeNm; // 카페명(파티랑 조인 cafe)
    private String endDt; // (party)
    private int orderUserCount;
    private int orderTagerUserCount;
    private int orderDrinkCount;
    private int orderTagerDrinkCount;
    private boolean orderState;
    private Set<OrderMenuCountReponse> orderMenuInfoList;


}
