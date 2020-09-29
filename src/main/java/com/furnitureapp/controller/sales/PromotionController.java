/*
Author: Ntumba Owin
Date of Creation: 25/9/2020
Desc:This is the PromotionController class, implements of the rest controller.

 */
package com.furnitureapp.controller.sales;

import com.furnitureapp.entity.sales.Promotion;
import com.furnitureapp.factory.sales.PromotionFactory;
import com.furnitureapp.service.sales.impl.PromotionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/promotion")
public class PromotionController {

    @Autowired
    private PromotionServiceImpl promotionService;

    @PostMapping("/create")
    public Promotion create(@RequestBody Promotion promo){
        Promotion promotion = PromotionFactory.createPromotion(promo.getPromoTitle(), promo.getDescription(),promo.getSeason(),promo.getYear());
        return promotionService.create(promotion);
    }
    @GetMapping("/read/{promoTitle}")
    public Promotion read(@PathVariable String promoTitle){
        return promotionService.read(promoTitle);
    }
    @PostMapping("/update")
    public Promotion update(@RequestBody Promotion promo){
        return promotionService.update(promo);
    }
    @DeleteMapping("/delete/{promoTitle}")
    public boolean delete(@PathVariable String promoTitle){
        return promotionService.delete(promoTitle);
    }
    @GetMapping("/list")
    public Set<Promotion> list(){
        return promotionService.list();
    }
}
