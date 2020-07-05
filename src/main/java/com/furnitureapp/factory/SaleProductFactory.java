/*
    Coder: Elvis Gene
    Date: 05-07-2020
    Description: This class is used to instantiate Product items belonging to a specific sale.
 */

package com.furnitureapp.factory;

import com.furnitureapp.entity.SaleProduct;
import com.furnitureapp.utility.Helper;

public class SaleProductFactory {

    public static SaleProduct createSaleProduct(int prodCode, int quantity){
        int saleCode = Helper.generateCode();

        return new SaleProduct.Builder()
                .setSaleCode(saleCode)
                .setProdCode(prodCode)
                .setQuantity(quantity)
                .build();
    }
}
