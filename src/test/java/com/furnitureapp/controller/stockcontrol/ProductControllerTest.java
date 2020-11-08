package com.furnitureapp.controller.stockcontrol;


import com.furnitureapp.entity.stockcontrol.Product;
import com.furnitureapp.factory.stockcontrol.ProductCategoryFactory;
import com.furnitureapp.factory.stockcontrol.ProductFactory;
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
public class ProductControllerTest {

    private static Product product = ProductFactory.createProduct("Bed", 50000, 200,
            175, 160, "This is a double bed");

    @Autowired
    private TestRestTemplate restTemplate = null;
    private String baseURL = "http://localhost:8080/Product/";

    @Test
    public void a_create() {
        String url = baseURL + "create";
        System.out.println("URL: " + url);
        System.out.println("Post data: " + product);
        ResponseEntity<Product> postResponse = restTemplate.postForEntity(url, product, Product.class);
        Assert.assertNotNull(postResponse);
        Assert.assertNotNull(postResponse.getBody());
        product = postResponse.getBody();
        System.out.println("Saved data: " + product);
        assertEquals(product.getProductCode(), postResponse.getBody().getProductCode());
    }

    @Test
    public void b_read() {
        String url = baseURL + "read" + product.getProductCode();
        System.out.println("URL: " + url);
        ResponseEntity<Product> response = restTemplate.getForEntity(url, Product.class);
        Assert.assertEquals(product.getName(), response.getBody().getName());
    }

    @Test
    public void c_update() {
        Product update = new Product.ProductBuilder().copy(product).setDescription("This is a wooden double bed").build();
        String url = baseURL + "update";
        System.out.println("URL: " + url);
        System.out.println("Post data: " + update);
        ResponseEntity<Product> response = restTemplate.postForEntity(url, update, Product.class);
        Assert.assertNotEquals(product.getDescription(), response.getBody().getDescription());
    }

    @Test
    public void e_delete() {
        String url = baseURL + "delete" + product.getProductCode();
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
