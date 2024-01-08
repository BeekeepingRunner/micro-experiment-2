package com.example.microexperiment.microorders.services;

import com.example.microexperiment.microorders.dto.OrderRequestDto;
import com.example.microexperiment.microorders.entities.Order;
import com.example.microexperiment.microorders.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private OrderRepository orderRepository;

    public Order submitOrder(OrderRequestDto orderRequestDto) {
        return null;
    }
}
