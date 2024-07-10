package com.dream.coffee.domain.order.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderPureInfo {
    private String partyName;//파티명(party)
    private String cafeNm;//카페명(파티랑 조인 cafe)
    private LocalDateTime endDt;//(party)
    private Long menuId;
    private String menuNm;

    public String getEndDt() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return  endDt.format(formatter);
    }
}
