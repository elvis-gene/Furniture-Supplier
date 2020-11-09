package com.furnitureapp.factory.stockcontrol;

/**
 * @author @Siba182
 * Description: Factory for Product entity
 */

import com.furnitureapp.entity.stockcontrol.Product;


public class ProductFactory {

    public static Product createProduct(String name, double price, float length, float width, float weight, String description){

        return new Product.ProductBuilder()
                .setProductCode(435)
                .setName(name)
                .setPrice(price)
                .setLength(length)
                .setWidth(width)
                .setWeight(weight)
                .setDescription(description)
                .build();
    }
}
