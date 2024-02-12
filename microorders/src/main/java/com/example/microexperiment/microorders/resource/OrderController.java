package com.example.microexperiment.microorders.resource;

import com.example.microexperiment.microorders.dto.OrderDto;
import com.example.microexperiment.microorders.dto.OrderRequestDto;
import com.example.microexperiment.microorders.entities.Order;
import com.example.microexperiment.microorders.mappers.OrderMapper;
import com.example.microexperiment.microorders.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
class OrderController {

    private final OrderService orderService;

    private final OrderMapper orderMapper = Mappers.getMapper(OrderMapper.class);

    @GetMapping("/orders")
    ResponseEntity<List<Order>> getAllOrders() {
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    @GetMapping("/orders/{orderId}")
    ResponseEntity<OrderDto> getOrder(@PathVariable(name = "orderId") Long orderId) {
        OrderDto orderDto = orderMapper.orderToDto(orderService.getOrder(orderId));
        return ResponseEntity.ok(orderDto);
    }

    @PostMapping("/orders")
    ResponseEntity<OrderDto> submitOrder(@RequestBody OrderRequestDto orderRequestDto) {
        OrderDto orderDto = orderMapper.orderToDto(orderService.submitOrder(orderRequestDto));
        return ResponseEntity.ok(orderDto);
    }
}
