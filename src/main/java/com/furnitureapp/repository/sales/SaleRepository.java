package com.furnitureapp.repository.sales;

import com.furnitureapp.entity.sales.Sale;
import com.furnitureapp.repository.IRepository;

import java.util.Set;

public interface SaleRepository extends IRepository<Sale, Long> {
    Set<Sale> list();
}
