package com.example.Cursor_HW12.service.impl;

import com.example.Cursor_HW12.entity.Product;
import com.example.Cursor_HW12.repository.ProductRepository;
import com.example.Cursor_HW12.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    private Optional<Character> findUniqueProductCode() {
        List<Product> products = productRepository.findAll();
        boolean[] usedCodes = new boolean[26];
        for (Product product : products) {
            usedCodes[product.getCode().charAt(0) - 'A'] = true;
        }

        for (int i = 0; i < usedCodes.length; i++) {
            if (!usedCodes[i]) {
                return Optional.of((char) ('A' + i));
            }
        }
        return Optional.empty();
    }

    @Override
    public Product createProduct(Product product) {
        Optional<Character> uniqueCode = findUniqueProductCode();
        if (uniqueCode.isPresent()) {
            product.setCode(String.valueOf(uniqueCode.get()));
            return productRepository.save(product);
        } else {
            return null;
        }
    }

    @Override
    public Product getProductByCode(char code) {
        return productRepository.findById(String.valueOf(code)).orElse(null);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(char code) {
        productRepository.deleteById(String.valueOf(code));
    }

}
