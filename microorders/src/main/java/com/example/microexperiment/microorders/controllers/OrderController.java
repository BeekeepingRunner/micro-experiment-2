package com.example.microexperiment.microorders.controllers;

import com.example.microexperiment.microorders.dto.OrderDto;
import com.example.microexperiment.microorders.dto.OrderRequestDto;
import com.example.microexperiment.microorders.mappers.OrderMapper;
import com.example.microexperiment.microorders.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
class OrderController {

    private final OrderService orderService;

    private final OrderMapper orderMapper = Mappers.getMapper(OrderMapper.class);

    @PostMapping("/order")
    ResponseEntity<OrderDto> submitOrder(@RequestBody OrderRequestDto orderRequestDto) {
        OrderDto orderDto = orderMapper.orderToDto(orderService.submitOrder(orderRequestDto));
        return ResponseEntity.ok(orderDto);
    }
}
