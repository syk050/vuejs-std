package com.example.vuejsstd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class VuejsStdApplication {

    public static void main(String[] args) {
        SpringApplication.run(VuejsStdApplication.class, args);
    }

}
