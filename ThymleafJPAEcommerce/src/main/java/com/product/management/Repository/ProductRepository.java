package com.product.management.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.product.management.Entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
