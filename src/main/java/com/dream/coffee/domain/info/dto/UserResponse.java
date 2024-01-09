package com.dream.coffee.domain.info.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserResponse {

    private Long userId;
    private String name;
    private String team;
    private String department;
    private String rank;
}
