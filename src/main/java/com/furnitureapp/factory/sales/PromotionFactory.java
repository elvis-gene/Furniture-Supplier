/*
Author: Ntumba Owin
Date of Creation: 4/7/2020
Desc:This is the PromotionFactory class, it helps with the encapsulation of all the object of the Promotion class.

 */

package com.furnitureapp.factory.sales;

import com.furnitureapp.entity.sales.Promotion;

import java.time.LocalDate;

public class PromotionFactory {
    public static Promotion createPromotion(String promoTitle, String description, String season, int year) {
        return new Promotion.PromotionBuilder()
                .setPromoTitle(promoTitle)
                .setDescription(description)
                .setStartDate(LocalDate.now())
                .setEndDate(LocalDate.now())
                .setSeason(season)
                .setYear(year)
                .build();
    }
}


