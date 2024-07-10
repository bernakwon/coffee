package com.dream.coffee.domain.info.repository;

import com.dream.coffee.domain.info.entity.Menu;
import com.dream.coffee.domain.info.entity.Party;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MenuRepository extends JpaRepository<Menu,Long> {
    @Query("SELECT m FROM Menu m WHERE m.cafeId = :cafeId")
    List<Menu> findMenusByCafeId(@Param("cafeId") String cafeId);
}