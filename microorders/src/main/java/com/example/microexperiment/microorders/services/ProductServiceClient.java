package com.example.microexperiment.microorders.services;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class ProductServiceClient {

    private final static String URI_DECREASE_STOCK_LEVEL = "decrease-stock-lvl";

    private final WebClient webClient;

    public void decreaseStockLevel(Long productId, Long quantity) {
        System.out.println("SENDING REQUEST TO PRODUCT SERVICE");
        Mono<DecreaseStockResponseDto> response = webClient.post()
                .uri(URI_DECREASE_STOCK_LEVEL)
                .bodyValue(new DecreaseStockRequestDto(productId, quantity))
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(DecreaseStockResponseDto.class);

        response.subscribe(responseDto -> {
            System.out.println("GETTING RESPONSE FROM PRODUCT SERVICE");
            System.out.println(responseDto);
        });
    }
}
