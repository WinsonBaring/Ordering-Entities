package com.example.OrderingEntities.controller;

import com.example.OrderingEntities.entities.Order;
import com.example.OrderingEntities.service.OrderService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }
//
    @PutMapping("/{orderId}")
    public ResponseEntity<Order> editOrder(@PathVariable int orderId, @RequestBody Order order) {
        try {
            Order editedOrder = orderService.editOrder(orderId, order);
            return ResponseEntity.ok(editedOrder);
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/{orderId}")
    public void deleteOrder(@PathVariable int orderId) {
        orderService.deleteOrder(orderId);
    }
}