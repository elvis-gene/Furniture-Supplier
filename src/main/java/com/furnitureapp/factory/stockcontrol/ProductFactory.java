package com.furnitureapp.factory.stockcontrol;

/**
 * @author @Siba182
 * Description: Factory for Product entity
 */

import com.furnitureapp.entity.stockcontrol.Product;
import com.furnitureapp.entity.stockcontrol.ProductCategory;
import com.furnitureapp.utility.Helper;


public class ProductFactory {

    public static Product createProduct(String name, double price, float length, float width, float weight, String description, ProductCategory category){

        return new Product.ProductBuilder()
                .setProductCode(435)
                .setName(name)
                .setPrice(price)
                .setLength(length)
                .setWidth(width)
                .setWeight(weight)
                .setDescription(description)
                .setCategory(category)
                .build();

    }
}
