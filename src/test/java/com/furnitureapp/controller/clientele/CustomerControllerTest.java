package com.furnitureapp.controller.clientele;
/*
 * @author: @nkosinathisola
 * Description: Customer Controller Tests
 */
import com.furnitureapp.entity.clientele.Customer;
import com.furnitureapp.entity.sales.Sale;
import com.furnitureapp.factory.clientele.CustomerFactory;
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
public class CustomerControllerTest {
    private static final String SECURITY_USERNAME = "random-client";
    private static final String SECURITY_PASSWORD = "user-password";

    private static Customer customer = CustomerFactory.createCustomer(
            "Nkosinathi Sola",
            "nkosinathisola@gmail.com",
            "0825173224",
            "24 Lancaster Street, Claremont Cape Town",
            "password");

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseUrl = "http://localhost:8080/customer";

    @Test
    public void a_create() {
        ResponseEntity<Customer> postResponse = restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .postForEntity(baseUrl + "/create", customer, Customer.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        System.out.println(postResponse.getBody());
    }

    @Test
    public void b_read() {
        String url = baseUrl + "/read/" + customer.getCustomerCode();
        ResponseEntity<Customer> response = restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .getForEntity(baseUrl + "/read/" + customer.getCustomerCode(), Customer.class);
        System.out.println(response.getBody());
    }

    @Test
    public void c_update() {
        Customer updatedCustomer = new Customer.CustomerBuilder().copy(customer).setCustomerCode(1).build();
        ResponseEntity<Customer> responseEntity = restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .postForEntity(baseUrl + "/update", updatedCustomer, Customer.class);
        assertNotEquals(customer.getCustomerCode(), responseEntity.getBody().getCustomerCode());
        System.out.println("Updated Customer:");
        System.out.println(responseEntity.getBody());
    }

    @Test
    public void d_getAll() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .exchange(baseUrl + "/all", HttpMethod.GET, entity, String.class);
        System.out.println(response.getBody());
    }

    @Test
    public void e_delete() {
        restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .delete(baseUrl + "/" +customer.getCustomerCode());
        d_getAll();
    }

}