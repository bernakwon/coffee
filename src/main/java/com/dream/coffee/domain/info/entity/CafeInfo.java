package com.dream.coffee.domain.info.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Builder
@Entity
public class CafeInfo {
    @Id
    private Long id;


}
