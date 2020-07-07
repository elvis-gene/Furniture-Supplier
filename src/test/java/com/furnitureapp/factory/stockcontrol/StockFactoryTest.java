package com.furnitureapp.factory.stockcontrol;

import com.furnitureapp.entity.stockcontrol.Stock;
import com.furnitureapp.factory.stockcontrol.StockFactory;
import org.junit.Assert;
import org.junit.Test;

public class StockFactoryTest {

    @Test
    public void createStock(){
        Stock stock = StockFactory.createStock(32);

        // Check whether the stock on a specific product is over 10 items.
        Assert.assertTrue(stock.getQuantity() > 10);
    }

}