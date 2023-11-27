package com.dream.coffee.domain.order.entity;

import com.dream.coffee.domain.info.entity.Party;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Builder;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Builder
@Entity
public class Order {
    @Id
    private Long id;
    @OneToOne
    private Party party;


}
