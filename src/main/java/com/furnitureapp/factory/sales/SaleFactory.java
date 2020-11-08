/*
    Coder: Elvis Gene
    Date: 05-07-2020
    Description: This class is used to instantiate Sale objects.
 */

package com.furnitureapp.factory.sales;

import com.furnitureapp.entity.sales.Sale;
import com.furnitureapp.entity.sales.SaleProduct;
import com.furnitureapp.repository.stockcontrol.ProductRepository;
//import com.furnitureapp.repository.stockcontrol.impl.ProductRepositoryImpl;
import com.furnitureapp.utility.Helper;

import java.time.LocalDateTime;
import java.util.Set;


public class SaleFactory {
    public static Sale createSale(){
        double totalAmount = 2700;

        return new Sale.SaleBuilder()
                .setSaleTime(LocalDateTime.now())
                .setTotalAmount(totalAmount).build();
    }
}
