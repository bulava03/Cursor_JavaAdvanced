package com.example.Cursor_HW12.service;

import com.example.Cursor_HW12.entity.Product;
import com.example.Cursor_HW12.repository.ProductRepository;
import com.example.Cursor_HW12.service.impl.ProductServiceImpl;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
public class ProductServiceImplTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    @Test
    public void testCreateProduct() {
        Product product = new Product(10.0, 2, 15.0);

        when(productRepository.save(any(Product.class))).thenReturn(product);

        Product savedProduct = productService.createProduct(product);

        assertNotNull(savedProduct);
        assertNotNull(savedProduct.getCode());

        verify(productRepository, times(1)).save(any(Product.class));
        ArgumentCaptor<Product> argument = ArgumentCaptor.forClass(Product.class);
        verify(productRepository).save(argument.capture());
        assertEquals(product.getPrice(), argument.getValue().getPrice(), 0.001);
        assertEquals(product.getSpecialQuantity(), argument.getValue().getSpecialQuantity());
        assertEquals(product.getSpecialPrice(), argument.getValue().getSpecialPrice(), 0.001);
    }

    @Test
    public void testCreateProductWhenAllCodesAreUsed() {
        when(productRepository.findAll()).thenReturn(
                Arrays.asList(
                        new Product("A", 10.0, 2, 15.0),
                        new Product("B", 20.0, 0, 0.0),
                        new Product("C", 15.0, 3, 40.0)
                )
        );
        Product createdProduct = productService.createProduct(new Product(25.0, 5, 100.0));
        assertEquals(null, createdProduct);
    }

    @Test
    public void testGetProductByCode() {
        when(productRepository.findById("A")).thenReturn(Optional.of(new Product("A", 10.0, 2, 15.0)));
        Product product = productService.getProductByCode('A');
        assertEquals(10.0, product.getPrice());
        assertEquals(2, product.getSpecialQuantity());
        assertEquals(15.0, product.getSpecialPrice());
    }

    @Test
    public void testGetAllProducts() {
        List<Product> productList = Arrays.asList(
                new Product("A", 10.0, 2, 15.0),
                new Product("B", 20.0, 0, 0.0),
                new Product("C", 15.0, 3, 40.0)
        );
        when(productRepository.findAll()).thenReturn(productList);
        List<Product> products = productService.getAllProducts();
        assertEquals(productList.size(), products.size());
    }

    @Test
    public void updateProductTest() {
        Product product = new Product("A", 100.0, 3, 250.0);
        Product updatedProduct = new Product("A", 150.0, 4, 500.0);

        when(productRepository.save(updatedProduct)).thenReturn(updatedProduct);

        Product savedProduct = productService.updateProduct(updatedProduct);

        assertEquals(savedProduct.getCode(), "A");
        assertEquals(savedProduct.getPrice(), 150.0);
        assertEquals(savedProduct.getSpecialQuantity(), 4);
        assertEquals(savedProduct.getSpecialPrice(), 500.0);
    }

    @Test
    public void testDeleteProduct() {
        doNothing().when(productRepository).deleteById("A");
        productService.deleteProduct('A');
        verify(productRepository, times(1)).deleteById("A");
    }

}
