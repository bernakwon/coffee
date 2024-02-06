package com.dream.coffee.domain.info.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String name;
    private String team;
    private String telNo;
    private String department;
    private String rank;
    @OneToMany(mappedBy = "user")
    private Set<PartyAttendee> partyAttendees;
}
