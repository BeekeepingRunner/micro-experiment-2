package com.example.microexperiment.microproducts.exception;

public class NegativeStockLevelException extends RuntimeException {

    public NegativeStockLevelException(String message) {
        super(message);
    }
}
