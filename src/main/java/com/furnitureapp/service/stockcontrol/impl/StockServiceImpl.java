package com.furnitureapp.service.stockcontrol.impl;

import com.furnitureapp.entity.stockcontrol.Stock;
import com.furnitureapp.repository.stockcontrol.StockRepository;
import com.furnitureapp.repository.stockcontrol.impl.StockRepositoryImpl;
import com.furnitureapp.service.stockcontrol.StockService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class StockServiceImpl implements StockService {

    private StockRepository repository;
    private static StockService service = null;

    public StockServiceImpl() {
        this.repository = StockRepositoryImpl.getStockRepository();
    }

    public static StockService getService() {
        if (service == null)
            service = new StockServiceImpl();
        return service;
    }

    @Override
    public Set<Stock> list() {
        return repository.list();
    }

    @Override
    public Stock create(Stock stock) {
        return repository.create(stock);
    }

    @Override
    public Stock read(Integer stockId) {
        return repository.read(stockId);
    }

    @Override
    public Stock update(Stock stock) {
        return repository.update(stock);
    }

    @Override
    public boolean delete(Integer stockId) {
        return repository.delete(stockId);
    }
}
