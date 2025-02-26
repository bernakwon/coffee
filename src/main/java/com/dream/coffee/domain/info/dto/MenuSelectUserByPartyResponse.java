package com.dream.coffee.domain.info.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MenuSelectUserByPartyResponse {


    private Long partyId;
    private String partyName;
    private Long userId;
    private String name;
    private String team;
    private String department;
    private String rank;
    private String telNo;
    private boolean isOrderComplete;


}
