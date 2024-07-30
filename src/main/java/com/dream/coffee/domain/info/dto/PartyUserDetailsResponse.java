package com.dream.coffee.domain.info.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;


@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PartyUserDetailsResponse {

    private Long partyId;
    private String partyName;
    private Long userCount;
    private Set<PartySelectUserResponse> userList;

}
