/*
    Coder: Elvis Gene
    Description: Interface for SaleServiceImpl
    Date: 05-Sept-2020
 */

package com.furnitureapp.service.sales;

import com.furnitureapp.entity.sales.Sale;
import com.furnitureapp.service.IService;

import java.util.Set;

public interface SaleService extends IService<Sale, Integer> {
    Set<Sale> list();

    // This method returns the list of sales
    // made in the past month
    Set<Sale> monthlySales();

    // This method returns the total
    // amount of money made from sales of the past month
    double monthlySalesAmount();
}
