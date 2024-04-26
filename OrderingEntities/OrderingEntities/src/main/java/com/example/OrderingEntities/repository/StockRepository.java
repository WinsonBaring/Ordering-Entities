package com.example.OrderingEntities.repository;

import com.example.OrderingEntities.entities.Order;
import com.example.OrderingEntities.entities.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockRepository  extends JpaRepository<Stock, Integer> {
}