package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Product;

@Repository
public interface ProdRepo extends JpaRepository<Product, Long>{

}
