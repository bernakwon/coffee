package com.dream.coffee.domain.info.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PartyInfoResponse {

    private Long partyId;
    private String partyName;
    private String endDt;


}
