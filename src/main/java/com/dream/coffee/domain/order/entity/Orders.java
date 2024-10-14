package com.dream.coffee.domain.order.entity;

import com.dream.coffee.domain.info.entity.Party;
import jakarta.persistence.*;
import lombok.*;

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
    @Setter
    private Long menuId;
    @Setter
    private String customMenu;

}
