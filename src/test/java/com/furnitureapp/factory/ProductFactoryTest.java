package com.furnitureapp.factory;

import com.furnitureapp.entity.Product;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProductFactoryTest {

    @Test
    public void createProduct() {
        Product product1 = ProductFactory.createProduct("Mattress", 2500, 137, 183
                , 32, "This is a double bed mattress"
                , ProductCategoryFactory.createProductCategory("Beds and Mattresses"));

        Product product2 = ProductFactory.createProduct("Mattress", 2500, 183, 183
                , 41, "This is a king bed mattress"
                , ProductCategoryFactory.createProductCategory("Beds and Mattresses"));

        assertNotEquals(product1, product2);

    }
}