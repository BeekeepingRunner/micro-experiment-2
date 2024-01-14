package com.example.microexperiment.microorders.services;

import com.example.microexperiment.microorders.dto.OrderRequestDto;
import com.example.microexperiment.microorders.entities.Order;
import com.example.microexperiment.microorders.entities.OrderStatus;
import com.example.microexperiment.microorders.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductServiceClient productServiceClient;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order submitOrder(OrderRequestDto orderRequestDto) {
        System.out.println("SUBMITTING ORDER");
        Order order = new Order();
        order.setCustomerId(orderRequestDto.customerId());
        order.setStatus(OrderStatus.NEW);
        System.out.println(order);

        // todo: how to return a response mixed with client response?
        productServiceClient.decreaseStockLevel(orderRequestDto.productId(), orderRequestDto.quantity());

        return orderRepository.save(order);
    }
}
