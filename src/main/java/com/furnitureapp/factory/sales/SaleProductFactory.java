/*
    Coder: Elvis Gene
    Date: 05-07-2020
    Description: This class is used to instantiate Product items belonging to a specific sale.
 */

package com.furnitureapp.factory.sales;

import com.furnitureapp.entity.sales.SaleProduct;
import com.furnitureapp.entity.sales.SaleProductCode;
import com.furnitureapp.utility.Helper;

public class SaleProductFactory {

    public static SaleProduct createSaleProduct(Integer saleCode, Integer prodCode, int quantity){
        SaleProductCode saleProductCode = new SaleProductCode(saleCode, prodCode);

        return new SaleProduct.Builder()
                .setId(saleProductCode)
                .setQuantity(quantity)
                .build();
    }
}
