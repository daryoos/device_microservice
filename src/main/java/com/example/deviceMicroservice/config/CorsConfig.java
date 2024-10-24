package com.example.deviceMicroservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

public class CorsConfig {
    @Bean
    public RestTemplate restTemplateBean() {
        return new RestTemplate();
    }
}
