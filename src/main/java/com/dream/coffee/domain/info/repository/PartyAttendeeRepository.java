package com.dream.coffee.domain.info.repository;

import com.dream.coffee.domain.info.dto.OrderStatusResponse;
import com.dream.coffee.domain.info.dto.PartyInfoResponse;
import com.dream.coffee.domain.info.entity.Party;
import com.dream.coffee.domain.info.entity.PartyAttendee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PartyAttendeeRepository extends JpaRepository<PartyAttendee,Long> {
    // Party ID를 기반으로 Party별 사용자 정보 조회
    @Query(value = "SELECT new com.dream.coffee.domain.info.dto.PartyInfoResponse(pa.party.partyId,pa.party.name,pa.party.endDt,pa.user.userId,pa.user.name,pa.user.department,pa.user.team,pa.user.level,pa.user.telNo) " +
            "FROM PartyAttendee pa  join pa.user join pa.party WHERE pa.party.partyId = :partyId")
    List<PartyInfoResponse> findAttendeesByPartyId(@Param("partyId") Long partyId);

    @Query("SELECT COUNT(DISTINCT pa.user) FROM PartyAttendee pa " +
            "LEFT JOIN Orders o ON pa.party.partyId = o.partyId AND pa.user.userId = o.userId " +
            "WHERE pa.party.partyId = :partyId ")
    Long countAttendeesByPartyId(@Param("partyId") Long partyId);

    @Query("SELECT COUNT(DISTINCT pa.user) FROM PartyAttendee pa " +
            "LEFT JOIN Orders o ON pa.party.partyId = o.partyId AND pa.user.userId = o.userId " +
            "WHERE pa.party.partyId = :partyId " +
            "AND (o.menuId IS NULL OR o.menuId <> :menuId)")
    Long countAttendeesByPartyIdNotMenuId(@Param("partyId") Long partyId,@Param("menuId") Long menuId);
}
