package com.furnitureapp.controller.staff;

import com.furnitureapp.entity.staff.Job;
import com.furnitureapp.factory.staff.JobFactory;
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
public class JobControllerTest {

    private static Job job = JobFactory.createJob("Software Engineer",
            "Develops and maintains software infrastructure");

    @Autowired
    private TestRestTemplate restTemplate = null;
    private String baseUrl = "http://localhost:8080/Job/";

    @Test
    public void a_create() {
        String url = baseUrl + "create";
        System.out.println("URL: " + url);
        System.out.println("Post data: " + job);
        ResponseEntity<Job> postResponse = restTemplate.withBasicAuth("manager", "admin-password").postForEntity(url, job, Job.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        job = postResponse.getBody();
        System.out.println("Saved data: " + job);
        assertEquals(job.getJobCode(), postResponse.getBody().getJobCode());
    }

    @Test
    public void d_list() {
        String url = baseUrl + "list";
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
        String url = baseUrl + "read/" + job.getJobCode();
        System.out.println("URL: " + url);
        ResponseEntity<Job> response = restTemplate.withBasicAuth("manager", "admin-password")
                .getForEntity(url, Job.class);
        assertEquals(job.getJobTitle(), response.getBody().getJobTitle());
    }

    @Test
    public void c_update() {
        Job update = new Job.JobBuilder().copy(job).setJobTitle("Systems Engineer").build();
        String url = baseUrl + "update";
        System.out.println("URL: " + url);
        System.out.println("Post data: " + update);
        ResponseEntity<Job> response = restTemplate.withBasicAuth("manager", "admin-password")
                .postForEntity(url, update, Job.class);
        assertNotEquals(job.getJobTitle(), response.getBody().getJobTitle());

    }

    @Test
    public void e_delete() {
        String url = baseUrl + "delete/" + job.getJobCode();
        System.out.println("URL: " + url);
        restTemplate.withBasicAuth("manager", "admin-password")
                .delete(url);
    }
}