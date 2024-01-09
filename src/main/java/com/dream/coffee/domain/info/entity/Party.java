package com.dream.coffee.domain.info.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Party {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long party_id;
    private String cafeId;
    private String name;
    private LocalDateTime endDt;


    @OneToMany(mappedBy = "party",fetch = FetchType.EAGER)
    private Set<PartyAttendee> partyAttendees;
}
