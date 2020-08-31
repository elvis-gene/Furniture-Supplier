package com.furnitureapp.repository.stockcontrol.impl;

import com.furnitureapp.entity.stockcontrol.Stock;
import com.furnitureapp.repository.stockcontrol.StockRepository;

import java.util.HashSet;
import java.util.Set;

public class StockRepositoryImpl implements StockRepository{

    private Set<Stock> stocks;
    private static StockRepository stockRepository = null;

    private StockRepositoryImpl() {
        this.stocks = new HashSet<>();
    }

    public static StockRepository getStockRepository(){
        if(stockRepository == null){
            stockRepository = new StockRepositoryImpl();
        }
        return stockRepository;
    }

    @Override
    public Stock create(Stock stock){
        stocks.add(stock);
        return stock;
    }

    @Override
    public Stock read(Integer catCode){
        return this.stocks.stream()
                .filter(stock -> stock.getProdCatCode()
                        .equals(catCode))
                .findAny()
                .orElse(null);
    }

    @Override
    public Stock update(Stock stock){
        Stock existingStock= read(stock.getProdCatCode());
        if(existingStock != null){
            stocks.remove(existingStock);
            stocks.add(stock);
        }
        return stock;
    }

    @Override
    public void delete(Integer catCode){
        Stock existingStock = read(catCode);
        if(existingStock != null){
            stocks.remove(existingStock);
        }
    }

    @Override
    public Set<Stock> list() {
        return stocks;
    }

}
