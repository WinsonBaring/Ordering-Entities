package com.example.OrderingEntities.controller;

import com.example.OrderingEntities.entities.Stock;
import com.example.OrderingEntities.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stocks")
public class StockController {
    @Autowired
    private StockService stockService;

    @GetMapping
    public List<Stock> getAllStocks() {
        return stockService.getAllStocks();
    }

    @PostMapping
    public Stock addStock(@RequestBody Stock stock) {
        return stockService.addStock(stock);
    }

    @PutMapping("/{productId}")
    public Stock modifyStock(@PathVariable int productId, @RequestBody Stock stock) {
        return stockService.modifyStock(productId, stock);
    }

    @GetMapping("/{productId}")
    public Stock selectStockItem(@PathVariable int productId) {
        return stockService.selectStockItem(productId);
    }
}
