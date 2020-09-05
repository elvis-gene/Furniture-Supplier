package com.furnitureapp.repository.sales;

import com.furnitureapp.entity.sales.Sale;
import com.furnitureapp.repository.IRepository;

import java.util.Set;

public interface SaleRepository extends IRepository<Sale, Integer> {
    Set<Sale> list();

    // This method returns the list of sales
    // made in the past month
    Set<Sale> monthlySales();

    // This method returns the total
    // amount of money made from sales of the past month
    double monthlySalesAmount();
}
