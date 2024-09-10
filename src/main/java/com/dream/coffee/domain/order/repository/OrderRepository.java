package com.dream.coffee.domain.order.repository;

import com.dream.coffee.domain.info.dto.*;
import com.dream.coffee.domain.info.entity.Cafe;
import com.dream.coffee.domain.order.dto.OrderPureInfo;
import com.dream.coffee.domain.order.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends JpaRepository<Orders,Long> {


    @Query("select new com.dream.coffee.domain.info.dto.MenuSelectUserResponse(m.id, case when o.customMenu is not null then o.customMenu else m.name end,u.name,u.telNo) from Orders o " +
            "left join Menu m on m.id=o.menuId " +
            "left join Users u on u.userId=o.userId " +
            "where o.menuId=:menuId " +
            "and o.partyId=:partyId")
    List<MenuSelectUserResponse> getMenuSelectUsers(@Param("menuId") Long menuId, @Param("partyId") Long partyId);

    @Query("select new com.dream.coffee.domain.order.dto.OrderPureInfo(p.name, c.cafeName, p.endDt, o.menuId, " +
            "case when o.customMenu is not null then o.customMenu else m.name end, " +
            "COUNT(DISTINCT o) ," +
            "COUNT(CASE WHEN o.menuId IS NOT NULL AND o.menuId != 99 THEN o.menuId END)) " +
            "from Party p " +
            "left join Cafe c on p.cafeId = c.cafeId " +
            "left join Orders o on p.partyId = o.partyId " +
            "left join Menu m on o.menuId = m.id " +
            "where p.partyId = :partyId " +
            "group by p.name, c.cafeName, p.endDt, o.menuId, o.customMenu, m.name")
    List<OrderPureInfo> findOrderStatusByPartyId(@Param("partyId") Long partyId);

    @Query("SELECT COUNT(o) FROM Orders o " +
            "WHERE o.partyId = :partyId AND o.userId IN " +
            "(SELECT pa.user.userId FROM PartyAttendee pa WHERE pa.party.partyId = :partyId )")
    Long countOrdersByPartyAndAttendees(@Param("partyId") Long partyId);

    @Query("select new com.dream.coffee.domain.info.dto.OrderedUserResponse(u.userId, u.name, u.team, u.department, u.level, u.telNo) " +
            "from Orders o " +
            "left join Users u on o.userId = u.userId " +
            "where o.partyId = :partyId and o.menuId = :menuId")
    List<OrderedUserResponse> findUsersByPartyIdAndMenuId(@Param("partyId") Long partyId, @Param("menuId") Long menuId);


    @Query("SELECT new  com.dream.coffee.domain.info.dto.MenuSelectUserByPartyResponse(p.partyId,p.name,u.userId, u.name, u.team, u.department, u.level, " +
            "CASE WHEN o.id IS NOT NULL THEN true ELSE false END) " +
            "FROM PartyAttendee pa " +
            "JOIN pa.user u " +
            "JOIN pa.party p " +
            "LEFT JOIN Orders o ON u.userId = o.userId AND o.partyId = :partyId " +
            "WHERE p.partyId = :partyId")
    List<MenuSelectUserByPartyResponse> getUsersByPartyIdWithOrderStatus(@Param("partyId") Long partyId);
}
