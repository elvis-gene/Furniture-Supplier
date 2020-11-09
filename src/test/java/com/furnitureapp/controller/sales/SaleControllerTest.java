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

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SaleControllerTest {
    private static final String ADMIN_USERNAME = "manager";
    private static final String ADMIN_PASSWORD = "admin-password";

    private static Sale sale = SaleFactory.createSale();

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseUrl = "http://localhost:8080/sale";

    @Test
    public void a_create() {
        System.out.println("Object to create: " + sale);
        ResponseEntity<Sale> postResponse = restTemplate
                .withBasicAuth(ADMIN_USERNAME,ADMIN_PASSWORD)
                .postForEntity(baseUrl + "/create", sale, Sale.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        System.out.println(postResponse.getBody());
    }

    @Test
    public void b_read() {
        ResponseEntity<Sale> response = restTemplate
                .withBasicAuth(ADMIN_USERNAME,ADMIN_PASSWORD)
                .getForEntity(baseUrl + "/read/" + 28 /*sale.getSaleCode()*/, Sale.class);

        assertNotEquals(sale.getTotalAmount(), response.getBody().getTotalAmount());
        System.out.println(response.getBody());
    }

    @Test
    public void c_update() {
        Sale newSale = new Sale.SaleBuilder().copy(sale).setTotalAmount(2000).build();
        ResponseEntity<Sale> responseEntity = restTemplate
                .withBasicAuth(ADMIN_USERNAME,ADMIN_PASSWORD)
                .postForEntity(baseUrl + "/update", newSale, Sale.class);
        assertNotEquals(responseEntity.getBody().getTotalAmount(), sale.getTotalAmount());
        System.out.println("Updated price:");
        System.out.println(responseEntity.getBody().getSaleCode());
        System.out.println(responseEntity.getBody().getTotalAmount());
    }

    @Test
    public void d_getAll() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate
                .withBasicAuth(ADMIN_USERNAME,ADMIN_PASSWORD)
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
                .withBasicAuth(ADMIN_USERNAME,ADMIN_PASSWORD)
        .delete(baseUrl + "/" +sale.getSaleCode());
        d_getAll();
    }

}
