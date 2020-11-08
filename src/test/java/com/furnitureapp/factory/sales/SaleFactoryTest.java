/*
    Coder: Elvis Gene
    Date: 05-07-2020
    Description: Tests of the SaleFactory class methods
 */

package com.furnitureapp.factory.sales;

import com.furnitureapp.entity.sales.Sale;
import com.furnitureapp.entity.sales.SaleProduct;
import com.furnitureapp.factory.sales.SaleFactory;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class SaleFactoryTest {

    @Test
    public void createSale(){
        Sale sale = SaleFactory.createSale();

        // Creating another sale using the copy method
        Sale anotherSale = new Sale.SaleBuilder().copy(sale).build();
        Assert.assertEquals(sale.getSaleCode(),anotherSale.getSaleCode());
    }
}
