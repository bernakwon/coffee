package com.dream.coffee.domain.order.repository;

import com.dream.coffee.domain.info.entity.Cafe;
import com.dream.coffee.domain.order.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders,Long>  {


}
