package com.dream.coffee.domain.order.repository;

import com.dream.coffee.domain.info.dto.MenuSelectUserResponse;
import com.dream.coffee.domain.info.entity.Cafe;
import com.dream.coffee.domain.order.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends JpaRepository<Orders,Long>  {


    @Query("select new com.dream.coffee.domain.info.dto.MenuSelectUserResponse(m.id,m.name,u.name,u.telNo) from Orders o " +
            "left join Menu m on m.id=o.menuId " +
            "left join Users u on u.userId=o.userId " +
            "where o.menuId=:menuId " +
            "and o.partyId=:partyId")
    List<MenuSelectUserResponse> getMenuSelectUsers(@Param("menuId") Long menuId,@Param("partyId") Long partyId);
}
