package com.pickme.pickmeappauthservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.pickme.pickmeappentityservice.models")
public class PickMeAppAuthServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PickMeAppAuthServiceApplication.class, args);
    }

}
