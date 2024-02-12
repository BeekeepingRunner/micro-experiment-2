package com.example.microexperiment.microorders.services;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class ProductServiceClient {

    private final static String URI_DECREASE_STOCK_LEVEL = "/decrease-stock-lvl";

    private final WebClient webClient;

    public Mono<ResponseEntity<DecreaseStockResponseDto>> decreaseStockLevel(Long productId, Long quantity) {
        return webClient.post()
                .uri(URI_DECREASE_STOCK_LEVEL)
                .bodyValue(new DecreaseStockRequestDto(productId, quantity))
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .toEntity(DecreaseStockResponseDto.class);
    }
}
