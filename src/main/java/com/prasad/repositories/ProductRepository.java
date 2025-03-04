package com.prasad.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prasad.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
