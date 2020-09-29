/*
Author: Munashe Magidi
Date of Creation: 25/9/2020
Desc:This is the DeliveryControllerTest class, tests the implementation of the rest controller app.
 */

package com.furnitureapp.controller.distribution;

import com.furnitureapp.entity.distribution.Delivery;
import com.furnitureapp.factory.distribution.DeliveryFactory;
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
public class DeliveryControllerTest {

    private static Delivery delivery;

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseUrl = "http://localhost:8080/delivery";


    @Test
    public void a_create() {
        Delivery delivery = DeliveryFactory.createDelivery(123,002,"32 Ty Street", 57489,"Shipped");
        String url = baseUrl + "create";
        ResponseEntity<Delivery> postResponse = restTemplate.postForEntity(url, delivery, Delivery.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        assertNotNull(postResponse.getStatusCode()); // check if 200 ??? figure out implementation here ASAP
        delivery = postResponse.getBody();
        System.out.println("Saved delivery: " + delivery);
        assertEquals(delivery.getDeliveryCode(), postResponse.getBody().getDeliveryCode());
    }

    @Test
    public void b_read() {
        String url = baseUrl + "read/";
        System.out.println("URL" + url);
        ResponseEntity <Delivery> response = restTemplate.getForEntity(url, Delivery.class);
        assertEquals(delivery.getDeliveryCode(), response.getBody().getDeliveryCode());



    }

    @Test
    public void c_update() {
        Delivery updated = new Delivery.DeliveryBuilder().copy(delivery).setDeliveryCode(55245).build();
        String url = baseUrl + "update/";
        ResponseEntity<Delivery> response = restTemplate.postForEntity(url, updated, Delivery.class);
        assertEquals(delivery.getDeliveryCode(), response.getBody().getDeliveryCode());

    }

    @Test
    public void e_delete() {

        String url = baseUrl + "delete/" + delivery.getDeliveryCode();
        System.out.println("URL: " + url);
        restTemplate.delete(url);


    }

    @Test
    public void d_list() {
        String url = baseUrl + "all";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null,headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println(response);
        System.out.println(response.getBody());

    }
}