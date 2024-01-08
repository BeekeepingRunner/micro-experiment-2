package com.example.microexperiment.microorders.dto;

import lombok.NonNull;

public record OrderRequestDto(
        @NonNull Long customerId,
        @NonNull Long productId,
        @NonNull Long quantity
) {
}
