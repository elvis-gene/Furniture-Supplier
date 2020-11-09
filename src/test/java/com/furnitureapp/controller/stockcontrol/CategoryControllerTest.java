package com.furnitureapp.controller.stockcontrol;

import com.furnitureapp.entity.stockcontrol.Category;
import com.furnitureapp.factory.stockcontrol.CategoryFactory;
import org.junit.Assert;
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

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class CategoryControllerTest {

    private static Category category =
            CategoryFactory.createCategory("Bed");

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/Category/";

    @Test
    public void a_create() {
        String url = baseURL + "create";
        System.out.println("URL: " + url);
        System.out.println("Post data: " + category);
        ResponseEntity<Category> postResponse = restTemplate
                .withBasicAuth("manager","admin-password")
                .postForEntity(url, category, Category.class);
       Assert.assertNotNull(postResponse);
       Assert.assertNotNull(postResponse.getBody());
        category = postResponse.getBody();
        System.out.println("Saved data: " + category);
        assertEquals(category.getCategoryCode(), postResponse.getBody().getCategoryCode());
    }

    @Test
    public void b_read() {
        String url = baseURL + "read/" + category.getCategoryCode();
        System.out.println("URL: " + url);
        ResponseEntity<Category> response = restTemplate
                .withBasicAuth("manager","admin-password")
                .getForEntity(url, Category.class);
       Assert.assertEquals(category.getCategoryCode(), response.getBody().getCategoryCode());
        System.out.println(response.getBody());

    }

    @Test
    public void c_update() {
        Category update = new Category.CategoryBuilder().copy(category).setCategoryName("Kitchenware").build();
        String url = baseURL + "update";
        System.out.println("URL: " + url);
        System.out.println("Post data: " + update);
        ResponseEntity<Category> response = restTemplate
                .withBasicAuth("manager","admin-password")
                .postForEntity(url, update, Category.class);
      Assert.assertNotEquals(category.getCategoryName(), response.getBody().getCategoryName());
    }

    @Test
    public void e_delete() {
        String url = baseURL + "delete/" + category.getCategoryCode();
        System.out.println("URL: " + url);
        restTemplate
                .withBasicAuth("manager","admin-password")
                .delete(url);
    }

    @Test
    public void d_list() {
        String url = baseURL + "list";
        System.out.println("URL: " + url);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate
                .withBasicAuth("manager","admin-password")
                .exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println(response);
        System.out.println(response.getBody());
    }
}
