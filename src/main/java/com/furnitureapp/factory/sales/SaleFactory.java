/*
    Coder: Elvis Gene
    Date: 05-07-2020
    Description: This class is used to instantiate Sale objects.
 */

package com.furnitureapp.factory.sales;

import com.furnitureapp.entity.sales.Sale;
import com.furnitureapp.utility.Helper;

import java.time.LocalDateTime;


public class SaleFactory {
    public static Sale createSale(double totalAmount){
        int saleCode = Helper.generateCode();

        return new Sale.SaleBuilder()
                .setSaleCode(saleCode)
                .setSaleTime(LocalDateTime.now())
                .setTotalAmount(totalAmount).build();
    }
}
