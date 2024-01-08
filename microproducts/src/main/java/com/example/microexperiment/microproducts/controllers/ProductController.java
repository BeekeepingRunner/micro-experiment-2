package com.example.microexperiment.microproducts.controllers;

import com.example.microexperiment.microproducts.entities.Product;
import com.example.microexperiment.microproducts.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
class ProductController {

    private final ProductService productService;

    @GetMapping("/products")
    ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.findAll());
    }

    @GetMapping("products/{productId}/stock-level")
    ResponseEntity<Long> getStockLevel(@PathVariable Long productId) {
        return ResponseEntity.ok(productService.getStockLevel(productId));
    }
}
