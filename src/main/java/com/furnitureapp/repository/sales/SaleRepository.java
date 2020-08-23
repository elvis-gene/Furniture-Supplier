package com.furnitureapp.repository.sales;

import com.furnitureapp.entity.sales.Sale;
import com.furnitureapp.repository.Repository;

import java.util.Set;

public interface SaleRepository extends Repository<Sale, Long> {
    Set<Sale> list();
}
