/*
Author: Ntumba Owin
Date of Creation: 4/7/2020
Desc:This is the PromotionFactoryTest class, it helps with the test of all the object of the Promotion class.

 */

package com.furnitureapp.factory;

import com.furnitureapp.entity.Promotion;
import com.furnitureapp.entity.Sale;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PromotionFactoryTest {

    @Test
    public void createPromotion() {
        Promotion promotion = PromotionFactory.createPromotion("Bed","06/11","06/12", "Buy one get the other one half price","Summer","2020");
        Promotion promotion1 = new Promotion.PromotionBuilder().copy(promotion).build();
        Assert.assertEquals(promotion.getYear(),promotion1.getYear());

    }
}