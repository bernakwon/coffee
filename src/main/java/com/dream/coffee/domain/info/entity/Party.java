package com.dream.coffee.domain.info.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class Party {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long partyId;
    private String cafeId;
    private String name;
    private LocalDateTime endDt;


    @OneToMany(mappedBy = "party")
    private Set<PartyAttendee> partyAttendees;
}
