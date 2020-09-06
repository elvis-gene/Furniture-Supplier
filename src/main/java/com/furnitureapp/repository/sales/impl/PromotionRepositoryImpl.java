/*
Author: Ntumba Owin
Date of Creation: 27/8/2020
Desc:This is the PromotionRepositoryImpl class, it contains the CRUD method for the Promotion entity.

 */
package com.furnitureapp.repository.sales.impl;

import com.furnitureapp.entity.sales.Promotion;
import com.furnitureapp.repository.sales.PromotionRepository;

import java.util.HashSet;
import java.util.Set;

public class PromotionRepositoryImpl implements PromotionRepository {

    //Declaration of the Promotion Set variable.
        private Set<Promotion> promotionSet;

    //Instantiation of PromotionRepository class.
        private static PromotionRepository promotionRepository = null;

   //PromotionRepositoryImpl constructor.
        public PromotionRepositoryImpl()
        {
            //Giving a value to the Promotion Set.
                promotionSet = new HashSet<>();
        }

   //
        public static PromotionRepository getPromotionRepository()
        {
           //Checking if a PromotionRepository already exist so that we can create a new one with the values that will
           // come from the PromotionRepositoryImpl.
            if (promotionRepository == null)
                promotionRepository = new PromotionRepositoryImpl();
            return promotionRepository;
        }
    // CRUD method that will be used to edit dataset

    //create method will add new promotions to the dataset
        @Override
        public Promotion create(Promotion promo)
        {
            promotionSet.add(promo);
            return promo;
        }
    //read method will read promoTitle to update or remove value from the dataset.
        @Override
        public Promotion read(String promoTitle)
        {
            Promotion promotion = null;

            //Going through the set to find the promotion that matches the promoTitle.
            for (Promotion p : this.promotionSet)
            {
                if (p.getPromoTitle().equalsIgnoreCase(promoTitle))
                {
                    promotion = p;
                    break;
                }
            }
            return promotion;
        }

    //update method will get the object and it will either delete or save the changes made to it.
        @Override
        public Promotion update(Promotion promo)
        {
            //get the object
            Promotion oldPromotion = read(promo.getPromoTitle());
            //update object
            if (oldPromotion != null)
            {
                this.promotionSet.remove(oldPromotion);
                this.promotionSet.add(promo);
            }
            return promo;
        }
    //delete will erase the object from the dataset
        @Override
        public boolean delete(String promoTitle)
        {
            boolean deleted = false;
            //get the object the erase it.
            Promotion promotion = read(promoTitle);
            if (promotion != null) {
                this.promotionSet.remove(promotion);
                deleted = true;
            }
            return deleted;
        }

    //This return the dataset with all its objects
        @Override
        public Set<Promotion> list()
        {
            return promotionSet;
        }
}
