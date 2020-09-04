/*
Author: Ntumba Owin
Date of Creation: 3/9/2020
Desc:This is the PromotionServiceImpl class, it implements the PromotionService Interface.

 */

package com.furnitureapp.service.sales.impl;

import com.furnitureapp.entity.sales.Promotion;
import com.furnitureapp.repository.sales.PromotionRepository;
import com.furnitureapp.repository.sales.impl.PromotionRepositoryImpl;
import com.furnitureapp.service.sales.PromotionService;

import java.util.Set;

public class PromotionServiceImpl implements PromotionService {

    //Instantiation of a CartService object and a CartRepository object.
    private static PromotionService service = null;
    private PromotionRepository repository;

    //Initialisation of the repository object with values coming from the CartRepositoryImpl
    private PromotionServiceImpl()
    {
        this.repository = PromotionRepositoryImpl.getPromotionRepository();
    }

    //Constructor checking if there is an existing service
    public static PromotionService getService()
    {
        if (service == null) service = new PromotionServiceImpl();
        return service;
    }

    @Override
        public Set<Promotion> getAll()
        {
            return this.repository.list();
        }

    @Override
        public Promotion create(Promotion promotion)
        {
            return this.repository.create(promotion);
        }

    @Override
        public Promotion read(String promoTitle)
        {
            return this.repository.read(promoTitle);
        }

    @Override
    public Promotion update(Promotion promotion)
        {
            return this.repository.update(promotion);
        }

    @Override
    public void delete(String promoTitle)
    {
        this.repository.delete(promoTitle);
    }
}
