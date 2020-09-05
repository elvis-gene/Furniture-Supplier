/*
Author: Ntumba Owin
Date of Creation: 28/8/2020
Desc:This is the PromotionRepositoryImplTest class, it contains all the CRUD method that must be tested with JUnit4.

 */
package com.furnitureapp.repository.sales.impl;

import com.furnitureapp.entity.sales.Promotion;
import com.furnitureapp.factory.sales.PromotionFactory;
import com.furnitureapp.repository.sales.PromotionRepository;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PromotionRepositoryImplTest {

    //Instantiation of an object of the class PromotionRepositoryImpl
    //And giving a value to the promotion object
    private static PromotionRepository promotionRepository = new PromotionRepositoryImpl();
    private static Promotion promotion = PromotionFactory.createPromotion("Summar Sale","Buy one get the other one half price","Summer",2018);

    //Creation of a new promotion inside the dataset
    @Test
    public void a_create()
    {
        Promotion createPromo = promotionRepository.create(promotion);
        assertEquals(createPromo.getPromoTitle(),promotion.getPromoTitle());
        System.out.println("Creation: " +createPromo);
    }

    //Read the dataset to find the specific promotion title
    @Test
    public void b_read()
    {
        Promotion readPromo = promotionRepository.read(promotion.getPromoTitle());
        System.out.println("Read: " +readPromo);
    }

    //Update the dataset with the new values
    @Test
    public void c_update()
    {
        Promotion updatedPromo = new Promotion.PromotionBuilder().copy(promotion).setPromoTitle("Summer Sales").build();
        updatedPromo = promotionRepository.update(updatedPromo);
        System.out.println("Update: " +updatedPromo);
        //System.out.println(promotionRepository.toString());
    }

    //Delete values based on the promotion title selected
    @Test
    public void d_delete()
    {
        promotionRepository.delete(promotion.getPromoTitle());
        System.out.println("Promotion deleted");
    }

}
