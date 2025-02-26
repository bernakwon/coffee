package com.dream.coffee.domain.info.repository;

import com.dream.coffee.domain.info.dto.MenuInfoResponse;
import com.dream.coffee.domain.info.entity.Menu;
import com.dream.coffee.domain.info.entity.Party;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MenuRepository extends JpaRepository<Menu,Long> {
    //tag가 없을때 전체 메뉴를 가져옴
    @Query("SELECT new com.dream.coffee.domain.info.dto.MenuInfoResponse(m.id, m.cafeId, c.cafeName, m.name, m.nameTag) " +
            "FROM Menu m " +
            "JOIN Cafe c ON m.cafeId = c.id " +
            "WHERE m.cafeId = (SELECT p.cafeId FROM Party p WHERE p.partyId = :partyId) " +
            "AND (:tag IS NULL OR m.nameTag LIKE %:tag%)")
    Page<MenuInfoResponse> findMenusByPartyId(
            @Param("partyId") String partyId,
            @Param("tag") String tag,
            Pageable pageable);
}