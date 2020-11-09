package com.furnitureapp.factory.stockcontrol;

import com.furnitureapp.entity.stockcontrol.Category;
import org.junit.Test;

import static org.junit.Assert.*;

public class CategoryFactoryTest {

    @Test
    public void createProductCategory() {
        Category pc1 = CategoryFactory.createCategory("Beds and Mattresses");
        Category pc2 = CategoryFactory.createCategory("Beds and Mattresses");

        assertNotEquals(pc1, pc2);

    }
}
