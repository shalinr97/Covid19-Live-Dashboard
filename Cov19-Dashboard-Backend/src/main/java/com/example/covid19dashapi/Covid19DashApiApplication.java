package com.example.covid19dashapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Covid19DashApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(Covid19DashApiApplication.class, args);
    }

    @Bean
    RestTemplate restTemplate(RestTemplateBuilder builder){
        return builder.build();
    }
}
