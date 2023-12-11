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
public class User {
    @Id
    private Long id;
    private String name;
    private String team;
    private String telNo;


    @ManyToOne(optional = false)
    @JoinColumn(name = "id",insertable=false, updatable=false)
    private Party parties;

    public Party getParties() {
        return parties;
    }

    public void setParties(Party parties) {
        this.parties = parties;
    }
}
