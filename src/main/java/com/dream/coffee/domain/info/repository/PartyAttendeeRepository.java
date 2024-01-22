package com.dream.coffee.domain.info.repository;

import com.dream.coffee.domain.info.entity.Party;
import com.dream.coffee.domain.info.entity.PartyAttendee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PartyAttendeeRepository extends JpaRepository<PartyAttendee,Long> {
    // Party ID를 기반으로 Party별 사용자 정보 조회
    @Query("SELECT pa FROM PartyAttendee pa WHERE pa.party.partyId = :partyId")
    List<PartyAttendee> findAttendeesByPartyId(@Param("partyId") Long partyId);
}
