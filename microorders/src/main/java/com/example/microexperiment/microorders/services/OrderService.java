package com.example.microexperiment.microorders.services;

import com.example.microexperiment.microorders.dto.OrderRequestDto;
import com.example.microexperiment.microorders.entities.Order;
import com.example.microexperiment.microorders.entities.OrderStatus;
import com.example.microexperiment.microorders.repositories.OrderRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductServiceClient productServiceClient;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrder(Long orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found with id = " + orderId));
    }

    @Transactional
    public Order submitOrder(OrderRequestDto orderRequestDto) {
        Order order = new Order();
        order.setCustomerId(orderRequestDto.customerId());
        order.setStatus(OrderStatus.NEW);
        order.setRequestedProductQuantity(orderRequestDto.quantity());

        ResponseEntity<DecreaseStockResponseDto> productResponse = productServiceClient
                .decreaseStockLevel(orderRequestDto.productId(), orderRequestDto.quantity())
                .block();

        if (productResponse != null && productResponse.getStatusCode().equals(HttpStatus.OK)) {
            order.setProductId(Objects.requireNonNull(productResponse.getBody()).productId());
            return orderRepository.save(order);
        } else {
            throw new RuntimeException("Cannot submit an order...");
        }
    }
}
