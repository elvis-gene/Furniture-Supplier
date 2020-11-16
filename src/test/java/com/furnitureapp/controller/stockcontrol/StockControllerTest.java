package com.furnitureapp.controller.stockcontrol;

import com.furnitureapp.entity.stockcontrol.Stock;
import com.furnitureapp.factory.stockcontrol.StockFactory;
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
public class StockControllerTest {

    private static final String ADMIN_USERNAME = "manager";
    private static final String ADMIN_PASSWORD = "admin-password";
    private static Stock stock = StockFactory.createStock(89);

    @Autowired
    private TestRestTemplate restTemplate = null;
    private String baseURL = "http://localhost:8080/stock/";

    @Test
    public void a_create() {
        String url = baseURL + "create";
        System.out.println("URL: " + url);
        System.out.println("Post data: " + stock);
        ResponseEntity<Stock> postResponse = restTemplate
                .withBasicAuth(ADMIN_USERNAME,ADMIN_PASSWORD)
                .postForEntity(url, stock, Stock.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        stock = postResponse.getBody();
        System.out.println("Saved data: " + stock);
        assertEquals(stock.getProdCatCode(), postResponse.getBody().getProdCatCode());
    }

    @Test
    public void d_list() {
        String url = baseURL + "all";
        System.out.println("URL: " + url);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate
                .withBasicAuth(ADMIN_USERNAME,ADMIN_PASSWORD)
                .exchange(url, HttpMethod.GET, entity, String.class);

        System.out.println(response);
        System.out.println(response.getBody());
    }

    @Test
    public void b_read() {
        String url = baseURL + "read/" + stock.getProdCatCode();
        System.out.println("URL: " + url);
        ResponseEntity<Stock> response = restTemplate
                .withBasicAuth(ADMIN_USERNAME,ADMIN_PASSWORD)
                .getForEntity(url, Stock.class);
        assertEquals(stock.getProdCatCode(), response.getBody().getProdCatCode());
    }

    @Test
    public void c_update() {
        Stock update = new Stock.StockBuilder().copy(stock).setQuantity(7).build();
        String url = baseURL + "update";
        System.out.println("URL: " + url);
        System.out.println("Post data: " + update);
        ResponseEntity<Stock> response = restTemplate
                .withBasicAuth(ADMIN_USERNAME,ADMIN_PASSWORD)
                .postForEntity(url, update, Stock.class);
        assertNotEquals(stock.getQuantity(), response.getBody().getQuantity());
    }

    @Test
    public void e_delete() {
        String url = baseURL + "delete/" + stock.getProdCatCode();
        System.out.println("URL: " + url);
        restTemplate
                .withBasicAuth(ADMIN_USERNAME,ADMIN_PASSWORD)
                .delete(url);
    }

}
