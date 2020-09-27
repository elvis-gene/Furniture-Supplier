/*
Author: Ntumba Owin
Date of Creation: 25/9/2020
Desc:This is the CartControllerTest class, tests the implementation of the rest controller app.

 */


package com.furnitureapp.controller.sales;

import com.furnitureapp.entity.sales.Cart;
import com.furnitureapp.entity.sales.SaleProduct;
import com.furnitureapp.factory.sales.CartFactory;
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
import java.util.ArrayList;
import static org.junit.Assert.*;



@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CartControllerTest {

    //Creation of an Arraylist to store cartItems
    ArrayList<SaleProduct> cartItems = new ArrayList<>();
    private static Cart cart;

    @Autowired
    private TestRestTemplate testTemplate;

    @Autowired
    private CartController cartController;
    private String baseUrl = "http://localhost:8080/cart/";

    @Test
    public void a_create(){

        String url = baseUrl + "create";
        cartItems.add(SaleProductFactory.createSaleProduct( 152,3));
        cart = CartFactory.createCart(cartItems, 2, 6000);
        System.out.println(cart);
        System.out.println(url);
        ResponseEntity<Cart> response = testTemplate.postForEntity(url, cart, Cart.class);
        assertEquals(cart.getCartNum(), response.getBody().getCartNum());
        assertNotNull(response.getBody());
        System.out.println(response.getBody());
        System.out.println(response.getStatusCodeValue());
    }

    @Test
    public void b_read() {

        String url = baseUrl + "read/" +cart.getCartNum();
        System.out.println("URL " +url);
        ResponseEntity<Cart> response = testTemplate.getForEntity(url, Cart.class);
        assertEquals(cart.getCartNum(),response.getBody().getCartNum());
        System.out.println("This cartNum was read");
    }

    @Test
    public void c_update() {

        Cart update = new Cart.CartBuilder().copy(cart).setNumbItems(4).build();
        String url = baseUrl +"update";
        System.out.println("URL " +url);
        ResponseEntity<Cart> response = testTemplate.postForEntity(url, update, Cart.class);
        assertEquals(cart.getCartNum(), response.getBody().getCartNum());
        System.out.println("Updated cart: " +response.getBody());
    }

    @Test
    public void e_delete() {

        String url = baseUrl +"delete/" +cart.getCartNum();
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