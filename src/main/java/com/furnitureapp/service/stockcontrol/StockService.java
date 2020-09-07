package com.furnitureapp.service.stockcontrol;

import com.furnitureapp.entity.stockcontrol.Stock;
import com.furnitureapp.service.IService;

import java.util.Set;

public interface StockService extends IService<Stock, Integer> {
    Set<Stock> list();
}
