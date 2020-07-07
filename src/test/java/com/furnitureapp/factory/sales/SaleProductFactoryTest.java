/*
    Coder: Elvis Gene
    Date: 05-07-2020
    Description: Tests of the SaleProductFactory class methods
 */

package com.furnitureapp.factory.sales;

import com.furnitureapp.entity.sales.SaleProduct;
import com.furnitureapp.factory.sales.SaleProductFactory;
import org.junit.Assert;
import org.junit.Test;

public class SaleProductFactoryTest {

    @Test
    public void createSaleProduct(){
        SaleProduct saleProduct = SaleProductFactory.createSaleProduct(7, 3);

        Assert.assertNotNull(saleProduct);
    }
}