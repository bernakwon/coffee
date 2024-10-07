package com.dream.coffee.domain.info.dto;

import com.dream.coffee.domain.info.entity.MenuIdPK;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class MenuInfoResponse {

    private Long id;

    private Long cafeId;


    private String cafeName;
    private String name;

    private String nameTag;

}
