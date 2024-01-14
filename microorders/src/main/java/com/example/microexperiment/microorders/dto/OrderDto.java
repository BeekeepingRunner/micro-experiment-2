package com.example.microexperiment.microorders.dto;

import com.example.microexperiment.microorders.entities.OrderStatus;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.NonNull;

@ApiResponse
public record OrderDto(
        @NonNull Long id,
        @NonNull Long customerId,
        @NonNull OrderStatus status
) {
}
