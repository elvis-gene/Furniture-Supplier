/*
Author: Ntumba Owin
Date of Creation: 4/7/2020
Desc:This is the PromotionFactory class, it helps with the encapsulation of all the object of the Promotion class.

 */

package com.furnitureapp.factory;

import com.furnitureapp.entity.Cart;
import com.furnitureapp.entity.Promotion;

public class PromotionFactory {
    public static Promotion createPromotion(String prodTitle,String startDate,String endDate, String description,String season,String year){
        //create a new Cart object
        Promotion promotion = null;

        //Check if there is a cart in the system
        //if the cart does not exist create a new one
        if(promotion == promotion)
        {
            return null;
        }
        //if there is an existing cart do not create one
        else {
            promotion = new Promotion.PromotionBuilder()
                    .setProdTitle(prodTitle)
                    .setDescription(description)
                    .setStartDate(startDate)
                    .setEndDate(endDate)
                    .setSeason(season)
                    .setYear(year)
                    .build();
            return null;
        }
    }
}

