package com.ecomm.retail.OrderService.repository;

import com.ecomm.retail.OrderService.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface OrderRepository extends JpaRepository<Order,Long> {
}
