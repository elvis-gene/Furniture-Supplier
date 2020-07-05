/*
Author: Ntumba Owin
Date of Creation: 4/7/2020
Desc:This is the PromotionFactory class, it helps with the encapsulation of all the object of the Promotion class.

 */

package com.furnitureapp.factory;

import com.furnitureapp.entity.Promotion;

public class PromotionFactory {
    public static Promotion createPromotion(String prodTitle, String startDate, String endDate, String description, String season, String year) {
        //create a new promotion object
        Promotion promotion = null;
        promotion = new Promotion.PromotionBuilder()
                .setProdTitle(prodTitle)
                .setDescription(description)
                .setStartDate(startDate)
                .setEndDate(endDate)
                .setSeason(season)
                .setYear(year)
                .build();
        return promotion;
    }
}


