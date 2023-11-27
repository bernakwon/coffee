package com.dream.coffee.domain.info.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Builder
@Entity
public class Party {
    @Id
    private Long id;
    private String name;
    @OneToMany(mappedBy = "parties")
    private List<UserInfo> users;
    private LocalDateTime endDt;

}
