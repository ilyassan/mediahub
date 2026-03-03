package com.ilyassan.mediahub.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

// @EnableConfigServer: turns this Spring Boot app into a Config Server.
// It exposes HTTP endpoints like /{service-name}/{profile}
// that other services call on startup to fetch their configuration.
@SpringBootApplication
@EnableConfigServer
public class ConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class, args);
    }
}
