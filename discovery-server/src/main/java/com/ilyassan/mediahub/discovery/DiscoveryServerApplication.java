package com.ilyassan.mediahub.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

// @SpringBootApplication: marks this class as the entry point of a Spring Boot app.
// It enables component scanning, auto-configuration, and configuration.

// @EnableEurekaServer: activates the Eureka Server behavior.
// Without this, it's just a plain Spring Boot app with no discovery features.
@SpringBootApplication
@EnableEurekaServer
public class DiscoveryServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DiscoveryServerApplication.class, args);
    }
}
