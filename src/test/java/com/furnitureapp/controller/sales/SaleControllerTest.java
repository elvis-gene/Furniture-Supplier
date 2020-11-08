package com.furnitureapp.controller.sales;

import com.furnitureapp.entity.sales.Sale;
import com.furnitureapp.factory.sales.SaleFactory;


import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SaleControllerTest {
//    private static final String ADMIN_ROLE = "ADMIN";
//    private static final String USER_ROLE = "USER";

    private static Sale sale = SaleFactory.createSale();

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseUrl = "http://localhost:8080/sale";

    @Test
    public void a_create() {
        ResponseEntity<Sale> postResponse = restTemplate
                .withBasicAuth("manager","admin-password")
                .postForEntity(baseUrl + "/create", sale, Sale.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        System.out.println(postResponse.getBody());
    }

    @Test
    public void b_read() {
        ResponseEntity<Sale> response = restTemplate
                .withBasicAuth("manager","admin-password")
                .getForEntity(baseUrl + "/read/" + sale.getSaleCode(), Sale.class);
        assertEquals(sale.getSaleCode(), response.getBody().getSaleCode());
        System.out.println(response.getBody());
    }

    @Test
    public void c_update() {
        Sale newSale = new Sale.SaleBuilder().copy(sale).setTotalAmount(2000).build();
        ResponseEntity<Sale> responseEntity = restTemplate
                .withBasicAuth("manager","admin-password")
                .postForEntity(baseUrl + "/update", newSale, Sale.class);
        assertEquals(sale.getSaleCode(), responseEntity.getBody().getSaleCode());
        System.out.println("Updated price:");
        System.out.println(responseEntity.getBody().getTotalAmount());
    }

    @Test
    public void d_getAll() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate
                .withBasicAuth("manager","admin-password")
                .exchange(baseUrl + "/all", HttpMethod.GET, entity, String.class);
        System.out.println(response.getBody());
    }

    @Test
    public void e_monthlySales() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseUrl + "/monthly_sales", HttpMethod.GET, entity, String.class);
        System.out.println(response.getBody());
    }

    @Test
    public void f_monthlyEntry() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Double> entity = new HttpEntity<>(null, headers);
        ResponseEntity<Double> response = restTemplate.exchange(baseUrl + "/monthly_entry", HttpMethod.GET, entity, Double.class);
        System.out.println("Total money made: R" + response.getBody());
    }

    @Test
    public void g_delete() {
        restTemplate
        .withBasicAuth("manager","admin-password")
        .delete(baseUrl + "/" +sale.getSaleCode());
        d_getAll();
    }

}
