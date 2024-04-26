package com.example.OrderingEntities.service;

import com.example.OrderingEntities.entities.Stock;
import com.example.OrderingEntities.repository.StockRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService {
    @Autowired
    private StockRepository stockRepository;

    public List<Stock> getAllStocks() {
        return stockRepository.findAll();
    }

    public Stock addStock(Stock stock) {
        return stockRepository.save(stock);
    }

    public Stock modifyStock(int productId, Stock stock) {
        if (stockRepository.existsById(productId)) {
            stock.setProductId(productId);
            return stockRepository.save(stock);
        } else {
            throw new EntityNotFoundException("Stock not found with Product ID: " + productId);
        }
    }

    public Stock selectStockItem(int productId) {
        return stockRepository.findById(productId)
                .orElseThrow(() -> new EntityNotFoundException("Stock not found with Product ID: " + productId));
    }
}
