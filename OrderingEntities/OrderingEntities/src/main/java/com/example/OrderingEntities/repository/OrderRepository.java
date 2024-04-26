package com.example.OrderingEntities.repository;

import com.example.OrderingEntities.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findByCustomerId(int customerId);
    void deleteByOrderId(int orderId);
}