/*
Author: Ntumba Owin
Date of Creation: 3/9/2020
Desc:This is the PromotionServiceImplTest class, tests the implementation of different business rules.

 */

package com.furnitureapp.service.sales.impl;

import com.furnitureapp.entity.sales.Promotion;
import com.furnitureapp.factory.sales.PromotionFactory;
import com.furnitureapp.service.sales.PromotionService;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PromotionServiceImplTest {

    private static PromotionService service = PromotionServiceImpl.getService();
    private static Promotion promotion = PromotionFactory.createPromotion("Summar Sale","Buy one get the other one half price","Summer",2018);

    @Test
    public void d_getAll()
    {
        Set<Promotion> promotions = service.getAll();
        assertEquals(1,promotions.size());
    }

    @Test
    public void a_create()
    {
        Promotion created = service.create(promotion);
        Assert.assertEquals(promotion.getPromoTitle(),created.getPromoTitle());
        System.out.println("Promotion created: " +created);
    }

    @Test
    public void b_read()
    {
        Promotion read = service.read(promotion.getPromoTitle());
        System.out.println("Read promotion: " +read);
    }

    @Test
    public void c_update()
    {
        Promotion updated = new Promotion.PromotionBuilder().copy(promotion).setPromoTitle("Summer").build();
        updated = service.update(updated);
        System.out.println("Updated promotion: " +updated);
    }

    @Test
    public void e_delete()
    {
        service.delete(promotion.getPromoTitle());
        System.out.println("Promotion deleted!");
    }
}
