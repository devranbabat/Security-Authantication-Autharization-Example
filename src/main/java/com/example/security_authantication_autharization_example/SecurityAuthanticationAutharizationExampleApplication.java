package com.example.security_authantication_autharization_example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SecurityAuthanticationAutharizationExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityAuthanticationAutharizationExampleApplication.class, args);
    }

}
