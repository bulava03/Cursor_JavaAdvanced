package com.example.Cursor_HW12.service;

import com.example.Cursor_HW12.entity.Product;

import java.util.List;

public interface ProductService {

    Product createProduct(Product product);

    Product getProductByCode(char code);

    List<Product> getAllProducts();

    Product updateProduct(Product product);

    void deleteProduct(char code);

}
