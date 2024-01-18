package com.dream.coffee.domain.info.repository;

import com.dream.coffee.domain.info.entity.Party;
import com.dream.coffee.domain.info.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartyRepository extends JpaRepository<Party,Long> {
    Party findByPartyId(Long partyId);
}
