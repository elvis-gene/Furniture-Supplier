package com.furnitureapp.factory;

import com.furnitureapp.entity.ProductCategory;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProductCategoryFactoryTest {

    @Test
    public void createProductCategory() {
        ProductCategory pc1 = ProductCategoryFactory.createProductCategory("Beds and Mattresses");
        ProductCategory pc2 = ProductCategoryFactory.createProductCategory("Beds and Mattresses");

        assertNotEquals(pc1, pc2);

    }
}