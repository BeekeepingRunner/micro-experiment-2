package com.example.microexperiment.microproducts.services;

import com.example.microexperiment.microproducts.entities.Product;
import com.example.microexperiment.microproducts.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Transactional
    public Long getStockLevel(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("product not found with id = " + productId));

        return product.getStockLevel();
    }


}
