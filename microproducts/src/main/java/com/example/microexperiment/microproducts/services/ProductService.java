package com.example.microexperiment.microproducts.services;

import com.example.microexperiment.microproducts.entities.Product;
import com.example.microexperiment.microproducts.exception.NegativeStockLevelException;
import com.example.microexperiment.microproducts.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    /*@Transactional
    public Long getStockLevel(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("product not found with id = " + productId));

        return product.getStockLevel();
    }*/

    @Transactional
    public DecreaseStockResponseDto decreaseStockLevel(DecreaseStockRequestDto requestDto) {
        Product product = productRepository.findById(requestDto.productId())
                .orElseThrow(() -> new RuntimeException("No product with id = " + requestDto.productId()));

        product.decreaseStockLevel(requestDto.quantity());
        product = productRepository.save(product);

        return new DecreaseStockResponseDto(product.getId(), product.getName(), product.getStockLevel());
    }
}
