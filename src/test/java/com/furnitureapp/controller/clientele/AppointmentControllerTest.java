package com.furnitureapp.controller.clientele;
/*
 * @author: @nkosinathisola
 * Description: Appointment Controller Tests
 */
import com.furnitureapp.entity.clientele.Appointment;
import com.furnitureapp.entity.clientele.Customer;
import com.furnitureapp.entity.sales.Sale;
import com.furnitureapp.factory.clientele.AppointmentFactory;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AppointmentControllerTest {
    private static final String SECURITY_USERNAME = "random-client";
    private static final String SECURITY_PASSWORD = "user-password";

    private static Appointment appointment = AppointmentFactory.createAppointment("Nkosinathi Sola","Business");

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseUrl = "http://localhost:8080/appointment";

    @Test
    public void a_create() {
        ResponseEntity<Appointment> postResponse = restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .postForEntity(baseUrl + "/create", appointment, Appointment.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        System.out.println(postResponse.getBody());
    }

    @Test
    public void b_read() {
        ResponseEntity<Appointment> response = restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .getForEntity(baseUrl + "/read/" + appointment.getCustomerName(), Appointment.class);
        System.out.println(response.getBody());
    }

    @Test
    public void c_update() {
        Appointment newAppointment = new Appointment.AppointmentBuilder().copy(appointment).setCustomerName("Nkosinathi Sola").build();
        ResponseEntity<Appointment> responseEntity = restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .postForEntity(baseUrl + "/update", newAppointment, Appointment.class);
        assertNotNull(appointment.getCustomerName(), responseEntity.getBody().getCustomerName());
        System.out.println("Updated Appointment:");
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
                .delete(baseUrl + "/" +appointment.getCustomerName());
        d_getAll();
    }

}