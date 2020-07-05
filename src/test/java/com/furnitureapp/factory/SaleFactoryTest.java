/*
    Coder: Elvis Gene
    Date: 05-07-2020
    Description: Tests of the SaleFactory class methods
 */

package com.furnitureapp.factory;

import com.furnitureapp.entity.Sale;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class SaleFactoryTest {

    @Test
    public void createSale(){
        Sale sale = SaleFactory.createSale(new Date().toString(), 400);
        // Creating another sale using the copy method
        Sale anotherSale = new Sale.SaleBuilder().copy(sale).build();

        Assert.assertEquals(sale.getSaleCode(),anotherSale.getSaleCode());
    }
}