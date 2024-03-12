package com.dream.coffee.domain.info.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MenuSelectGroupUserResponse {

    private String menuNm;
    private long count;
    private String menuId;
    private List<SelectUser> ordererList;

    static class SelectUser{
        String userNm;
        String telNo;

        public SelectUser(String userNm, String telNo) {
            this.userNm = userNm;
            this.telNo = telNo;
        }
    }
}
