/*
Author: Ntumba Owin
Date of Creation: 4/7/2020
Desc:This is the PromotionFactoryTest class, it helps with the test of all the object of the Promotion class.

 */

package com.furnitureapp.factory.sales;

import com.furnitureapp.entity.sales.Promotion;
import com.furnitureapp.factory.sales.PromotionFactory;
import org.junit.Assert;
import org.junit.Test;

public class PromotionFactoryTest {

    @Test
    public void createPromotion() {
        Promotion promotion = PromotionFactory.createPromotion("Bed","Buy one get the other one half price","Summer",2018);
        Promotion promotion1 = new Promotion.PromotionBuilder().copy(promotion).build();
        Assert.assertEquals(promotion.getYear(),promotion1.getYear());

    }
}
