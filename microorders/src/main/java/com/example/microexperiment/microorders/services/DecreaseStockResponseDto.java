package com.example.microexperiment.microorders.services;

public record DecreaseStockResponseDto(Long productId, String productName, Long currentStockLvl) {
}
