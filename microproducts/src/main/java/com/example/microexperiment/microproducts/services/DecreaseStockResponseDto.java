package com.example.microexperiment.microproducts.services;

public record DecreaseStockResponseDto(Long productId, String productName, Long currentStockLvl) {
}
