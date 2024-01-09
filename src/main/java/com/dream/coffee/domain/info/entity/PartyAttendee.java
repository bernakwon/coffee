package com.dream.coffee.domain.info.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class PartyAttendee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long attendanceId;


    @ManyToOne
    @JoinColumn(name = "party_id")
    private Party party;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    @Column(name = "attendance_status")
    private String attendanceStatus;

}