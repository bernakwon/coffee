package com.dream.coffee.domain.info.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MenuSelectGroupUserResponse {


    private String menuId;
    private String menuNm;
    private long count;

    private Set<SelectUser> ordererList;

}
