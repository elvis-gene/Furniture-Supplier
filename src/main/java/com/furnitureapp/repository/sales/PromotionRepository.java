/*
Author: Ntumba Owin
Date of Creation: 27/8/2020
Desc:This is the PromotionRepository interface, it contains the data type that will be use to store the promotions.

 */
package com.furnitureapp.repository.sales;

import com.furnitureapp.entity.sales.Promotion;
import com.furnitureapp.repository.IRepository;

import java.util.Set;

// Identified by the promotion title, Second type to be a String.
public interface PromotionRepository extends IRepository<Promotion, String> {

    //Creation of the set that will contain the Cart objects and on which the CRUD method will be applied
        Set<Promotion>list();
}
