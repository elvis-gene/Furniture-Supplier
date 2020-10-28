/*
Author: Ntumba Owin
Date of Creation: 3/9/2020
Desc:This is the PromotionServiceImpl class, it implements the PromotionService Interface.

 */

package com.furnitureapp.service.sales.impl;

import com.furnitureapp.entity.sales.Promotion;
import com.furnitureapp.repository.sales.PromotionRepository;
import com.furnitureapp.service.sales.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PromotionServiceImpl implements PromotionService {

    //Instantiation of PromotionRepository object.
    @Autowired
    private PromotionRepository repository;


    @Override
        public Set<Promotion> list()
        {
            return this.repository.findAll().stream().collect(Collectors.toSet());
        }

    @Override
    public Set<Promotion> selectBySeason() {
       Set<Promotion> promotions = list();
       Set<Promotion> season = new HashSet<>();
       for (Promotion promotion : promotions){
           if (promotion.getPromoTitle().trim().toLowerCase().equalsIgnoreCase(promotion.getSeason()));
           season.add(promotion);
       }
        return season;
    }

    @Override
        public Promotion create(Promotion promotion)
        {
            return this.repository.save(promotion);
        }

    @Override
        public Promotion read(String promoTitle)
        {
            return this.repository.findById(promoTitle).orElse(null);
        }

    @Override
    public Promotion update(Promotion promotion)
        {
            if (this.repository.existsById(promotion.getPromoTitle())){
                return this.repository.save(promotion);
            }
            return null;
        }

    @Override
    public boolean delete(String promoTitle)
    {
         this.repository.deleteById(promoTitle);
         if (this.repository.existsById(promoTitle)) return false;
         else  return true;
    }
}
