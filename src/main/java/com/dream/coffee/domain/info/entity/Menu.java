package com.dream.coffee.domain.info.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Menu {
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Id
    private Long cafeId;
    private String name;

}
