package com.event.sourcing.cqrs.productservice.repository;

import com.event.sourcing.cqrs.productservice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,String> {
}
