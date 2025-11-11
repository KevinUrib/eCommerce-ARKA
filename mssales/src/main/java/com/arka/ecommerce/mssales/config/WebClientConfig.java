package com.arka.ecommerce.mssales.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Bean
    public WebClient.Builder webClientBuilder() {
        return WebClient.builder();
    }


    @Bean
    public WebClient movementWebClient(WebClient.Builder builder) {
        return builder
                .baseUrl("http://localhost:8084")
                .build();
    }

    @Bean
    public WebClient inventoryWebClient(WebClient.Builder builder) {
        return builder.baseUrl("http://localhost:8081/api/v1/inventory").build();
    }

    @Bean
    public WebClient orderWebClient(WebClient.Builder builder) {
        return builder.baseUrl("http://localhost:8081/api/v1/order").build();
    }
}
