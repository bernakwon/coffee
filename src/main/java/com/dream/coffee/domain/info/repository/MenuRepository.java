package com.dream.coffee.domain.info.repository;

import com.dream.coffee.domain.info.entity.Menu;
import com.dream.coffee.domain.info.entity.Party;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu,Long> {
}