package com.example.microexperiment.microproducts.entities;

import com.example.microexperiment.microproducts.exception.NegativeStockLevelException;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private BigDecimal pricePerPiece;

    @Column
    private Long stockLevel;

    public void decreaseStockLevel(Long quantity) throws NegativeStockLevelException {
        Long resultLvl = stockLevel - quantity;
        if (resultLvl < 0) {
            throw new NegativeStockLevelException("Stock level cannot be negative");
        }

        this.stockLevel = resultLvl;
    }
}
