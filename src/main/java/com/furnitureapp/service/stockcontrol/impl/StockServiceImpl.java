package com.furnitureapp.service.stockcontrol.impl;

import com.furnitureapp.entity.stockcontrol.Stock;
import com.furnitureapp.repository.stockcontrol.StockRepository;
import com.furnitureapp.service.stockcontrol.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class StockServiceImpl implements StockService {

    @Autowired
    private StockRepository repository;

    @Override
    public Set<Stock> list() {
        return repository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public Stock create(Stock stock) {
        return repository.save(stock);
    }

    @Override
    public Stock read(Integer stockId) {
        return repository.getOne(stockId);
    }

    @Override
    public Stock update(Stock stock) {
        return repository.save(stock);
    }

    @Override
    public boolean delete(Integer stockId) {
        repository.deleteById(stockId);
        return repository.existsById(stockId);
    }
}
