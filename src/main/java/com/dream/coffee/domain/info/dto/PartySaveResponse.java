package com.dream.coffee.domain.info.dto;


import com.dream.coffee.domain.info.entity.Party;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PartySaveResponse {

    private Party party;
}
