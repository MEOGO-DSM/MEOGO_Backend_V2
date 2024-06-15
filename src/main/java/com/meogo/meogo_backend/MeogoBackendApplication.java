package com.meogo.meogo_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EnableWebSecurity
@SpringBootApplication
@ConfigurationPropertiesScan
public class MeogoBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(MeogoBackendApplication.class, args);
    }
}
