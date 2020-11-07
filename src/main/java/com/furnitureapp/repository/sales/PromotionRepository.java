/*
Author: Ntumba Owin
Date of Creation: 27/8/2020
Desc:This is the PromotionRepository interface, it contains the data type that will be use to store the promotions.

 */
package com.furnitureapp.repository.sales;

import com.furnitureapp.entity.sales.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// Identified by the promotion title, Second type to be a String.
public interface PromotionRepository extends JpaRepository<Promotion, String> {
    
}
