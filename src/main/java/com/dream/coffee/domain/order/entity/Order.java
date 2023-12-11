package com.dream.coffee.domain.order.entity;

import com.dream.coffee.domain.info.entity.Party;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Order {
    @Id
    private Long id;
    @OneToOne
    private Party party;


}
