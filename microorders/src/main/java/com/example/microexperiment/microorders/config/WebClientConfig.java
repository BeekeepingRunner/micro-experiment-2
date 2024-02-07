package com.example.microexperiment.microorders.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Value("${product.service.url}")
    private String PRODUCT_SERVICE_BASE_URL;

    @Bean
    public WebClient webClient() {
        return WebClient.builder()
                .baseUrl(PRODUCT_SERVICE_BASE_URL)
                .build();
    }
}
