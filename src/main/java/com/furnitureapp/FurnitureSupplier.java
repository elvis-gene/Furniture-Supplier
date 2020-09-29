package com.furnitureapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FurnitureSupplier {
<<<<<<< HEAD

    @RequestMapping("/")
    public String homePage(){
        return "Spring-boot works!";
    }

=======
>>>>>>> upstream/master
    public static void main(String[] args) {
        SpringApplication.run(FurnitureSupplier.class, args);
    }
}