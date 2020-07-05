package com.furnitureapp.factory;

import com.furnitureapp.entity.Stock;
import com.furnitureapp.utility.Helper;

public class StockFactory {

    public static Stock createStock(int quantity){
        // Will come from the class ProductCategory latter
        int prodCatCode = Helper.generateCode();

        return new Stock.StockBuilder().
                setProdCatCode(prodCatCode).
                setQuantity(quantity).build();
    }
}
