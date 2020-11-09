package com.furnitureapp.controller.staff;

import com.furnitureapp.entity.staff.Employee;
import com.furnitureapp.factory.staff.EmployeeFactory;
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
public class EmployeeControllerTest {

    private static Employee employee = EmployeeFactory.createEmployee("Yaseen Johnston", "1 ABC Street",
            "Yaseen@XYZ.com", "0123987456",
            "9am - 5pm", 240000.00, "0125");

    @Autowired
    private TestRestTemplate restTemplate = null;
    private String baseURL = "http://localhost:8080/Employee/";

    @Test
    public void a_create() {
        String url = baseURL + "create";
        System.out.println("URL: " + url);
        System.out.println("Post data: " + employee);
        ResponseEntity<Employee> postResponse1 = restTemplate.withBasicAuth("manager", "admin-password").postForEntity(url, employee, Employee.class);
        assertNotNull(postResponse1);
        assertNotNull(postResponse1.getBody());
        employee = postResponse1.getBody();
        System.out.println("Saved data: " + employee);
        assertEquals(employee.getEmployeeCode(), postResponse1.getBody().getEmployeeCode());
    }

    @Test
    public void d_list() {
        String url = baseURL + "list";
        System.out.println("URL: " + url);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.withBasicAuth("manager", "admin-password")
                .exchange(url, HttpMethod.GET, entity, String.class);

        System.out.println(response);
        System.out.println(response.getBody());
    }

    @Test
    public void b_read() {
        String url = baseURL + "read/" + employee.getEmployeeCode();
        System.out.println("URL: " + url);
        ResponseEntity<Employee> response = restTemplate.withBasicAuth("manager", "admin-password")
                .getForEntity(url, Employee.class);
        assertEquals(employee.getFullName(), response.getBody().getFullName());
    }

    @Test
    public void c_update() {
        Employee update = new Employee.EmployeeBuilder().copy(employee).setEmailAddress("Yaseen@AOL.com").build();
        String url = baseURL + "update";
        System.out.println("URL: " + url);
        System.out.println("Post data: " + update);
        ResponseEntity<Employee> response = restTemplate.withBasicAuth("manager", "admin-password")
                .postForEntity(url, update, Employee.class);
        assertNotEquals(employee.getEmailAddress(), response.getBody().getEmailAddress());
    }

    @Test
    public void e_delete() {
        String url = baseURL + "delete/" + employee.getEmployeeCode();
        System.out.println("URL: " + url);
        restTemplate.withBasicAuth("manager", "admin-password")
                .delete(url);
    }
}