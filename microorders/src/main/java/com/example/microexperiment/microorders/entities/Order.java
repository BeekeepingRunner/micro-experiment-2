package com.example.microexperiment.microorders.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long customerId; // simulating a customer for now

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    private Long productId;

    private Long requestedProductQuantity;
}
