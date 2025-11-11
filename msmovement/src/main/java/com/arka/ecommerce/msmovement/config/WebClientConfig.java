package com.arka.ecommerce.msmovement.config;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import org.springframework.context.annotation.*;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.*;
import reactor.netty.http.client.HttpClient;
import java.time.Duration;

@Configuration
public class WebClientConfig {

    @Bean
    public WebClient webClient(WebClient.Builder builder) {
        HttpClient httpClient = HttpClient.create()
                .responseTimeout(Duration.ofSeconds(5))
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000)
                .doOnConnected(conn -> conn.addHandlerLast(new ReadTimeoutHandler(5)));

        return builder
                .baseUrl("http://localhost:8084")
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .build();
    }

    @Bean
    public WebClient inventoryWebClient(WebClient.Builder builder) {
    return builder.baseUrl("http://localhost:8081/api/v1/inventory").build();
}
}
