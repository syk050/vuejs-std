package com.example.vuejsstd;

import com.example.vuejsstd.entity.Customer;
import com.example.vuejsstd.entity.CustomerRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@EnableJpaAuditing
@SpringBootApplication
public class VuejsStdApplication{

    @Autowired
    private CustomerRepository repository;

    public static void main(String[] args){
        SpringApplication.run(VuejsStdApplication.class, args);
    }

}
