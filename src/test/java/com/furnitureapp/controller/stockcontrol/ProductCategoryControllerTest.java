package com.furnitureapp.controller.stockcontrol;

import com.furnitureapp.entity.stockcontrol.Product;
import com.furnitureapp.entity.stockcontrol.ProductCategory;
import com.furnitureapp.factory.stockcontrol.ProductCategoryFactory;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
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

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class ProductCategoryControllerTest {

    private static ProductCategory productCategory =
            ProductCategoryFactory.createProductCategory("Bed");

    @Autowired
    private TestRestTemplate restTemplate = null;
    private String baseURL = "http://localhost:8080/ProductCategory/";

    @Test
    public void a_create() {
        String url = baseURL + "create";
        System.out.println("URL: " + url);
        System.out.println("Post data: " + productCategory);
        ResponseEntity<ProductCategory> postResponse = restTemplate.postForEntity(url, productCategory, ProductCategory.class);
        Assert.assertNotNull(postResponse);
        Assert.assertNotNull(postResponse.getBody());
        productCategory = postResponse.getBody();
        System.out.println("Saved data: " + productCategory);
        assertEquals(productCategory.getCategoryCode(), postResponse.getBody().getCategoryCode());
    }

    @Test
    public void b_read() {
        String url = baseURL + "read/" + productCategory.getCategoryCode();
        System.out.println("URL: " + url);
        ResponseEntity<ProductCategory> response = restTemplate.getForEntity(url, ProductCategory.class);
        Assert.assertEquals(productCategory.getCategoryCode(), response.getBody().getCategoryCode());
    }

    @Test
    public void c_update() {
        ProductCategory update = new ProductCategory.ProductCategoryBuilder().copy(productCategory).setCategoryName("Kitchenware").build();
        String url = baseURL + "update";
        System.out.println("URL: " + url);
        System.out.println("Post data: " + update);
        ResponseEntity<ProductCategory> response = restTemplate.postForEntity(url, update, ProductCategory.class);
        Assert.assertNotEquals(productCategory.getCategoryName(), response.getBody().getCategoryName());
    }

    @Test
    public void e_delete() {
        String url = baseURL + "delete/" + productCategory.getCategoryCode();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
    }

    @Test
    public void d_list() {
        String url = baseURL + "list";
        System.out.println("URL: " + url);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        System.out.println(response);
        System.out.println(response.getBody());
    }
}