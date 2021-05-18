package com.example.aclresource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class AclResourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AclResourceApplication.class, args);
    }
}
