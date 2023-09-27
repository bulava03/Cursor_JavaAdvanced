package com.example.Cursor_HW12.repository;

import com.example.Cursor_HW12.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, String> {
}
