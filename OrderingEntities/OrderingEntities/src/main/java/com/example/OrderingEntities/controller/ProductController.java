package com.example.OrderingEntities.controller;

import com.example.OrderingEntities.entities.Product;
import com.example.OrderingEntities.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @PutMapping("/{productId}")
    public Product modifyProduct(@PathVariable int productId, @RequestBody Product product) {
        return productService.modifyProduct(productId, product);
    }

    @GetMapping("/{productId}")
    public Product selectProduct(@PathVariable int productId) {
        return productService.selectProduct(productId);
    }
}