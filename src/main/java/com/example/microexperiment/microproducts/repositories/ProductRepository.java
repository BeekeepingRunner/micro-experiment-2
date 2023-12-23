package com.example.microexperiment.microproducts.repositories;

import com.example.microexperiment.microproducts.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
