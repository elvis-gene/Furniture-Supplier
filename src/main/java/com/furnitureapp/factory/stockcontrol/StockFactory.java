package com.furnitureapp.factory.stockcontrol;

import com.furnitureapp.entity.stockcontrol.Stock;
import com.furnitureapp.utility.Helper;

public class StockFactory {

    public static Stock createStock(int quantity){
        // Will come from the class ProductCategory latter
        Long prodCatCode = Helper.generateCode();

        return new Stock.StockBuilder().
                setProdCatCode(prodCatCode).
                setQuantity(quantity).build();
    }
}
