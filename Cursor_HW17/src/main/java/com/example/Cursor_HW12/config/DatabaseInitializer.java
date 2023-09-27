package com.example.Cursor_HW12.config;

import com.example.Cursor_HW12.entity.Product;
import com.example.Cursor_HW12.service.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseInitializer {

    @Bean
    public CommandLineRunner initDatabase(ProductService productService) {
        return args -> {
            if (productService.getAllProducts().isEmpty()) {
                productService.createProduct(new Product(1.25, 3, 3.00));
                productService.createProduct(new Product(4.25, 0, 0));
                productService.createProduct(new Product(1.00, 6, 5.00));
                productService.createProduct(new Product(0.75, 0, 0));
            }
        };
    }

}
