package com.dream.coffee.domain.order.repository;

import com.dream.coffee.domain.info.dto.MenuSelectUserResponse;
import com.dream.coffee.domain.info.dto.OrderStatusResponse;
import com.dream.coffee.domain.info.entity.Cafe;
import com.dream.coffee.domain.order.dto.OrderPureInfo;
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

    @Query("select new com.dream.coffee.domain.order.dto.OrderPureInfo(p.name, c.name, p.endDt, o.menuId, m.name, COUNT(DISTINCT o.userId), COUNT(o.menuId)) " +
            "from Orders o " +
            "left join Party p on p.partyId = o.partyId " +
            "left join Cafe c on o.cafeId = c.id " +
            "left join Menu m on o.menuId = m.id " +
            "where o.partyId = :partyId " +
            "group by p.name, c.name, p.endDt, o.menuId, m.name")
    List<OrderPureInfo> findOrderStatusByPartyId(@Param("partyId") Long partyId);

    @Query("SELECT COUNT(o) FROM Orders o " +
            "WHERE o.partyId = :partyId AND o.userId IN " +
            "(SELECT pa.user.userId FROM PartyAttendee pa WHERE pa.party.partyId = :partyId )")
    Long countOrdersByPartyAndAttendees(@Param("partyId") Long partyId);
}
