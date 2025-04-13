package com.pickme.pickmeappauthservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EntityScan("com.pickme.pickmeappentityservice.models")
@EnableCaching
@EnableDiscoveryClient
public class PickMeAppAuthServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PickMeAppAuthServiceApplication.class, args);
    }

}
