package com.syr.zen.shift_service;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class ShiftApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShiftApplication.class, args);
    }
}	