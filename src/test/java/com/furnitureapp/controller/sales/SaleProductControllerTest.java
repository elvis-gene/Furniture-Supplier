package com.furnitureapp.controller.sales;

import com.furnitureapp.entity.sales.SaleProduct;
import com.furnitureapp.factory.sales.SaleProductFactory;
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
public class SaleProductControllerTest {

    private static final SaleProduct saleProduct = SaleProductFactory.createSaleProduct(1, 435, 4);

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseUrl = "http://localhost:8080/sale_product";

    @Test
    public void a_create() {
        ResponseEntity<SaleProduct> postResponse = restTemplate.postForEntity(baseUrl + "/create", saleProduct, SaleProduct.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        System.out.println(postResponse.getBody());
    }

    @Test
    public void b_read() {
        String url = baseUrl + "/read/" + saleProduct.getId();
        ResponseEntity<SaleProduct> response = restTemplate.getForEntity(url, SaleProduct.class);
        assertEquals(saleProduct.getId(), response.getBody().getId());
        System.out.println(response.getBody());
    }

    @Test
    public void c_update() {
        SaleProduct updatedSP = new SaleProduct.Builder().copy(saleProduct).setQuantity(5).build();
        ResponseEntity<SaleProduct> responseEntity = restTemplate.postForEntity(baseUrl + "/update", updatedSP, SaleProduct.class);
        assertNotEquals(saleProduct.getQuantity(), responseEntity.getBody().getQuantity());
        System.out.println("Updated quantity:");
        System.out.println(responseEntity.getBody());
    }

    @Test
    public void d_getAll() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseUrl + "/all", HttpMethod.GET, entity, String.class);
        System.out.println(response.getBody());
    }

    @Test
    public void e_delete() {
        restTemplate.delete(baseUrl + "/" + saleProduct.getId());
        d_getAll();
    }
}
