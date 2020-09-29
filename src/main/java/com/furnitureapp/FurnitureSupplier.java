package com.furnitureapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class FurnitureSupplier {

    @RequestMapping("/")
    public String homePage(){
        return "Spring-boot works!";
    }

    public static void main(String[] args) {
        SpringApplication.run(FurnitureSupplier.class, args);
    }
}
