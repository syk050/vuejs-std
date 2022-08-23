package com.example.vuejsstd;

import com.example.vuejsstd.entity.Customer;
import com.example.vuejsstd.entity.CustomerRepository;
import com.example.vuejsstd.storage.StorageService;
import com.example.vuejsstd.storage.StorageProperties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;


@EnableJpaAuditing
@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class VuejsStdApplication{

    @Autowired
    private CustomerRepository repository;

    public static void main(String[] args){
        SpringApplication.run(VuejsStdApplication.class, args);
    }

    @Bean
    CommandLineRunner init(StorageService storageService) {
        return (args) -> {
            storageService.deleteAll();
            storageService.init();
        };
    }

}
