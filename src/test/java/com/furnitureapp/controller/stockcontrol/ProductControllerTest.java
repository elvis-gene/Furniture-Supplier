package com.furnitureapp.controller.stockcontrol;

import com.furnitureapp.entity.stockcontrol.Product;
import com.furnitureapp.factory.stockcontrol.ProductFactory;

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
public class ProductControllerTest {

    private static Product product = ProductFactory.createProduct("Bed", 50000, 200,
            175, 160, "This is a double bed");

    private static final String ADMIN_USERNAME = "manager";
    private static final String ADMIN_PASSWORD = "admin-password";

    @Autowired
    private TestRestTemplate restTemplate = null;
    private String baseURL = "http://localhost:8080/Product/";

    @Test
    public void a_create() {
        String url = baseURL + "create";
        System.out.println("URL: " + url);
        System.out.println("Post data: " + product);
        ResponseEntity<Product> postResponse = restTemplate
                .withBasicAuth(ADMIN_USERNAME,ADMIN_PASSWORD)
                .postForEntity(url, product, Product.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        product = postResponse.getBody();
        System.out.println("Saved data: " + product);
        assertEquals(product.getProductCode(), postResponse.getBody().getProductCode());
    }

    @Test
    public void b_read() {
        String url = baseURL + "read/" + product.getProductCode();
        System.out.println("URL: " + url);
        ResponseEntity<Product> response = restTemplate
                .withBasicAuth(ADMIN_USERNAME,ADMIN_PASSWORD)
                .getForEntity(url, Product.class);
        System.out.println(product.getProductCode());
        assertEquals(product.getName(), response.getBody().getName());
    }

    @Test
    public void c_update() {
        Product update = new Product.ProductBuilder().copy(product).setDescription("This is a wooden double bed").build();
        String url = baseURL + "update";
        System.out.println("URL: " + url);
        System.out.println("Post data: " + update);
        ResponseEntity<Product> response = restTemplate
                .withBasicAuth(ADMIN_USERNAME,ADMIN_PASSWORD)
                .postForEntity(url, update, Product.class);
        assertNotEquals(product.getDescription(), response.getBody().getDescription());
    }

    @Test
    public void e_delete() {
        String url = baseURL + "delete/" + product.getProductCode();
        System.out.println("URL: " + url);
        restTemplate
                .withBasicAuth(ADMIN_USERNAME,ADMIN_PASSWORD)
                .delete(url);
    }

    @Test
    public void d_list() {
        String url = baseURL + "list";
        System.out.println("URL: " + url);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate
                .withBasicAuth(ADMIN_USERNAME,ADMIN_PASSWORD)
                .exchange(url, HttpMethod.GET, entity, String.class);

        System.out.println(response);
        System.out.println(response.getBody());
    }
}
