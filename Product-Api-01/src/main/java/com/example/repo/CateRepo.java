package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Category;

@Repository
public interface CateRepo extends JpaRepository<Category, Long> {

}
