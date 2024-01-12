package com.example.microexperiment.microorders.services;

import com.example.microexperiment.microorders.dto.OrderRequestDto;
import com.example.microexperiment.microorders.entities.Order;
import com.example.microexperiment.microorders.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    // todo: implement
    public Order submitOrder(OrderRequestDto orderRequestDto) {
        return null;
    }
}
