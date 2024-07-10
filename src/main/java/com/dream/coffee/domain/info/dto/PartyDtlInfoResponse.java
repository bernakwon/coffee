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
public class PartyDtlInfoResponse {

    private Long partyId;
    private String partyName;
    private String endDt;
    private int allUserCount;
    private int completedOrderUserCount;
    private List<OrderMenuInfo> orderMenuList;

}
