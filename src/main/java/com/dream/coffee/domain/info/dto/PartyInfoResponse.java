package com.dream.coffee.domain.info.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PartyInfoResponse {

    private Long partyId;
    private String partyName;
    private LocalDateTime endDt;
    private Long userId;
    private String name;
    private String department;
    private String team;
    private String rank;
    private String telNo;


}
