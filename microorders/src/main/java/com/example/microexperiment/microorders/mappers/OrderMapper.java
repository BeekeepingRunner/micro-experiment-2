package com.example.microexperiment.microorders.mappers;

import com.example.microexperiment.microorders.dto.OrderDto;
import com.example.microexperiment.microorders.entities.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface OrderMapper {

    OrderDto orderToDto(Order order);
}
