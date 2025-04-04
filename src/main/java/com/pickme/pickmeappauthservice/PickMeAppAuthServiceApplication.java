package com.pickme.pickmeappauthservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EntityScan("com.pickme.pickmeappentityservice.models")
@EnableCaching
public class PickMeAppAuthServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PickMeAppAuthServiceApplication.class, args);
    }

}
