package com.dream.coffee.domain.order.entity;

import com.dream.coffee.domain.info.entity.Party;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long partyId;
    private Long cafeId;
    private Long userId;
    private Long menuId;
    private String directMenu;

}
