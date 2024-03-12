package com.dream.coffee.domain.order.repository;

import com.dream.coffee.domain.info.dto.MenuSelectUserResponse;
import com.dream.coffee.domain.info.entity.Cafe;
import com.dream.coffee.domain.order.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Orders,Long>  {


    @Query("select new MenuSelectUserResponse(m.name,m.menuId,u.name,u.telNo) from Orders o " +
            "left join Menu m on m.id=o.menu_id" +
            "left join Users u on u.id=o.user_id" +
            "where o.menuId=:menuId" +
            "and o.partyId=:partyId")
    List<MenuSelectUserResponse> getMenuSelectUsers(Long menuId, Long partyId);
}
