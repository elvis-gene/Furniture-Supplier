/*
    Coder: Elvis Gene
    Description: This class is used to instantiate Sale objects.
 */

package com.furnitureapp.factory;

import com.furnitureapp.entity.Sale;
import com.furnitureapp.utility.Helper;

public class SaleFactory {
    public static Sale createSale(String saleTime, double totalAmount){
        int saleCode = Helper.generateCode();

        return new Sale.SaleBuilder()
                .setSaleCode(saleCode)
                .setSaleTime(saleTime)
                .setTotalAmount(totalAmount).build();
    }
}
