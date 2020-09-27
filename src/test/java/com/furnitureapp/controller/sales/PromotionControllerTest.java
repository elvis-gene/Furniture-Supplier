/*
Author: Ntumba Owin
Date of Creation: 25/9/2020
Desc:This is the PromotionControllerTest class, tests the implementation of the rest controller app.

 */
package com.furnitureapp.controller.sales;

import com.furnitureapp.entity.sales.Cart;
import com.furnitureapp.entity.sales.Promotion;
import com.furnitureapp.factory.sales.PromotionFactory;
import com.furnitureapp.service.sales.PromotionService;
import com.furnitureapp.service.sales.impl.PromotionServiceImpl;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PromotionControllerTest {

    private static Promotion promotion = PromotionFactory.createPromotion("Summer Sale","Buy one get the other one half price","Summer",2018);

    @Autowired
    private TestRestTemplate testTemplate;
    @Autowired
    private static PromotionService service = PromotionServiceImpl.getService();
    private String baseUrl = "http://localhost:8080/promotion/";

    @Test
    public void a_create() {
        String url = baseUrl + "create";
        System.out.println(url);
        Promotion promo = PromotionFactory.createPromotion(promotion.getPromoTitle(),promotion.getDescription(),promotion.getSeason(),promotion.getYear());
        System.out.println("Promotion: " +promo);
        ResponseEntity<Promotion> response = testTemplate.postForEntity(url, promo, Promotion.class);
        assertEquals(promo.getPromoTitle(), response.getBody().getPromoTitle());
        assertNotNull(response.getBody());
        System.out.println(response.getBody());
        System.out.println(response.getStatusCodeValue());
    }

    @Test
    public void b_read() {

        String url = baseUrl + "read/" +promotion.getPromoTitle();
        System.out.println("URL " +url);
        ResponseEntity<Promotion> response = testTemplate.getForEntity(url, Promotion.class);
        assertEquals(promotion.getPromoTitle(),response.getBody().getPromoTitle());
        System.out.println("This promoTitle was read");
    }
    @Test
    public void c_update() {

        Promotion update = new Promotion.PromotionBuilder().copy(promotion).setYear(2020).build();
        String url = baseUrl +"update";
        System.out.println("URL " +url);
        ResponseEntity<Promotion> response = testTemplate.postForEntity(url, update, Promotion.class);
        assertEquals(promotion.getPromoTitle(), response.getBody().getPromoTitle());
        System.out.println("Updated promotion: " +response.getBody());
    }

    @Test
    public void e_delete() {

        String url = baseUrl +"delete/" +promotion.getPromoTitle();
        System.out.println("URL " +url);
        testTemplate.delete(url);
        //assertNull(resp);
    }

    @Test
    public void d_list() {

        String url = baseUrl +"list";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response  = testTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println(response.getBody());
    }
}