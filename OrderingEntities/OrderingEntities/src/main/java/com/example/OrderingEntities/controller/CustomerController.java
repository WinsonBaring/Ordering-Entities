package com.example.OrderingEntities.controller;

import com.example.OrderingEntities.entities.Customer;
import com.example.OrderingEntities.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }
    // Get All Customer
    @PutMapping("/{customerId}")
    public Customer editCustomer(@PathVariable int customerId, @RequestBody Customer customer) {
        customer.setCustomerId(customerId);
        return customerService.editCustomer(customer);
    }

    @DeleteMapping("/{customerId}")
    public void deleteCustomer(@PathVariable int customerId) {
        customerService.deleteCustomer(customerId);
    }
}