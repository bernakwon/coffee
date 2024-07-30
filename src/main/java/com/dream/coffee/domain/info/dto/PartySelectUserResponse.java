package com.dream.coffee.domain.info.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PartySelectUserResponse {

    private String name;
    private String team;
    private String department;
    private String rank;
    private boolean isOrderComplete;
}
