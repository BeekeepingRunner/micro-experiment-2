package com.example.microexperiment.microorders.dto;

import com.example.microexperiment.microorders.entities.OrderStatus;
import lombok.NonNull;

public record OrderDto(
        @NonNull Long id,
        @NonNull Long customerId,
        @NonNull OrderStatus status
) {
}
