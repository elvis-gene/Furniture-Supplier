/*
Author: Ntumba Owin
Date of Creation: 3/9/2020
Desc:This is the PromotionService interface, it contains all the business rules to hide the functionalities of the CartRepository.

 */

package com.furnitureapp.service.sales;

import com.furnitureapp.entity.sales.Promotion;
import com.furnitureapp.service.IService;

import java.util.Set;

public interface PromotionService extends IService<Promotion, String> {

    //Creation of the set that will contain the Promotion services
    Set<Promotion> list();

    //getAll promotion per seasons
    public Set<Promotion> selectBySeason();

}
