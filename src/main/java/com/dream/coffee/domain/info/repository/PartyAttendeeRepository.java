package com.dream.coffee.domain.info.repository;

import com.dream.coffee.domain.info.entity.Party;
import com.dream.coffee.domain.info.entity.PartyAttendee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartyAttendeeRepository extends JpaRepository<PartyAttendee,Long> {
}
