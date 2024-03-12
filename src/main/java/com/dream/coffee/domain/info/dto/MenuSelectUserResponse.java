package com.dream.coffee.domain.info.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;


@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MenuSelectUserResponse {

   private String menuNm;
    private String menuId;
    private String userNm;
   private String telNo;


}
