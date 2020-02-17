package com.order.orderservice.repository;

import com.order.orderservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("Select o from Order o where o.customerId=?1")
    public List<Order> findOrderbyCustomerId(long id);
}
