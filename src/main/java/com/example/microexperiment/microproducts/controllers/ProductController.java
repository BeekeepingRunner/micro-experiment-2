package com.example.microexperiment.microproducts.controllers;

import com.example.microexperiment.microproducts.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
class ProductController {

    private final ProductService productService;

    @GetMapping("/product/{productId}/stock-level")
    ResponseEntity<Long> getStockLevel(@PathVariable Long productId) {
        return ResponseEntity.ok(productService.getStockLevel(productId));
    }
}
