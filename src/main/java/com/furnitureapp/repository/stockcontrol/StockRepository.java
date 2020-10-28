package com.furnitureapp.repository.stockcontrol;

import com.furnitureapp.entity.stockcontrol.Stock;
import com.furnitureapp.repository.IRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface StockRepository extends JpaRepository<Stock, Integer> {
}
