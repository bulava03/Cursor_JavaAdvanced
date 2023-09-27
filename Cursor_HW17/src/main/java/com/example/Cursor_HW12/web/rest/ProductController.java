package com.example.Cursor_HW12.web.rest;

import com.example.Cursor_HW12.entity.Product;
import com.example.Cursor_HW12.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product/*")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/create")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        List<Product> products = productService.getAllProducts();
        if (products.size() >= 26) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Product createdProduct = productService.createProduct(product);
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }

    @GetMapping("/read/{code}")
    public ResponseEntity<?> getProductByCode(@PathVariable char code) {
        Product product = productService.getProductByCode(code);
        if (product != null) {
            return new ResponseEntity<>(product, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Продукт не знайдено", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/read")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        Product updatedProduct = productService.updateProduct(product);
        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{code}")
    public ResponseEntity<Void> deleteProduct(@PathVariable char code) {
        productService.deleteProduct(code);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
