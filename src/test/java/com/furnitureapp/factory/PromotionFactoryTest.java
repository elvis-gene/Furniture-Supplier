package com.furnitureapp.factory;

import com.furnitureapp.entity.Promotion;
import org.junit.Test;

import static org.junit.Assert.*;

public class PromotionFactoryTest {

    @Test
    public void createPromotion() {
        Promotion promotion = PromotionFactory.createPromotion("Bed","06/11","06/12", "Buy one get the other one half price","Summer","2020");
        Promotion promotion1 = PromotionFactory.createPromotion("Table","06/11","06/12", "Buy one get 3 chairs for free","Summer","2020");

    }
}