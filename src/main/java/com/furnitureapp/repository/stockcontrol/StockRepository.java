package com.furnitureapp.repository.stockcontrol;

import com.furnitureapp.entity.stockcontrol.Stock;
import com.furnitureapp.repository.IRepository;

import java.util.Set;

public interface StockRepository extends IRepository<Stock, Integer> {
    Set<Stock> list();
}
