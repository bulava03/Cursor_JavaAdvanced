package com.example.Cursor_HW12.service;

import com.example.Cursor_HW12.entity.Product;
import com.example.Cursor_HW12.service.impl.BasketServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class BasketServiceImplTest {

    @InjectMocks
    private BasketServiceImpl basketService;

    @Mock
    private ProductService productService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldCalculateBasketValueForEmptyString() {
        List<Product> products = Arrays.asList(
                new Product("A", 50, 3, 130),
                new Product("B", 30, 2, 45),
                new Product("C", 20, 0, 0)
        );
        when(productService.getAllProducts()).thenReturn(products);
        when(productService.getProductByCode('A')).thenReturn(new Product("A", 50, 0, 0));
        when(productService.getProductByCode('B')).thenReturn(new Product("B", 30, 0, 0));
        when(productService.getProductByCode('C')).thenReturn(new Product("C", 20, 0, 0));

        String basket = "";

        double expectedBasketValue = 0;
        assertEquals(expectedBasketValue, basketService.calculateBasketValue(basket));
    }

    @Test
    void shouldCalculateBasketValueWithNoSpecials() {
        List<Product> products = Arrays.asList(
                new Product("A", 50, 0, 0),
                new Product("B", 30, 0, 0),
                new Product("C", 20, 0, 0)
        );
        when(productService.getAllProducts()).thenReturn(products);
        when(productService.getProductByCode('A')).thenReturn(new Product("A", 50, 0, 0));
        when(productService.getProductByCode('B')).thenReturn(new Product("B", 30, 0, 0));
        when(productService.getProductByCode('C')).thenReturn(new Product("C", 20, 0, 0));

        String basket = "AAABBC";

        double expectedBasketValue = 230;
        assertEquals(expectedBasketValue, basketService.calculateBasketValue(basket));
    }

    @Test
    void shouldCalculateBasketValueWithSpecialsExactMultiple() {
        List<Product> products = Arrays.asList(
                new Product("A", 50, 3, 130),
                new Product("B", 30, 2, 45),
                new Product("C", 20, 0, 0)
        );
        when(productService.getAllProducts()).thenReturn(products);
        when(productService.getProductByCode('A')).thenReturn(new Product("A", 50, 0, 0));
        when(productService.getProductByCode('B')).thenReturn(new Product("B", 30, 0, 0));
        when(productService.getProductByCode('C')).thenReturn(new Product("C", 20, 0, 0));

        String basket = "AAABBBCC";

        double expectedBasketValue = 245;
        assertEquals(expectedBasketValue, basketService.calculateBasketValue(basket));
    }

    @Test
    void shouldCalculateBasketValueWithSpecialsNotExactMultiple() {
        List<Product> products = Arrays.asList(
                new Product("A", 50, 3, 130),
                new Product("B", 30, 2, 45),
                new Product("C", 20, 0, 0)
        );
        when(productService.getAllProducts()).thenReturn(products);
        when(productService.getProductByCode('A')).thenReturn(new Product("A", 50, 0, 0));
        when(productService.getProductByCode('B')).thenReturn(new Product("B", 30, 0, 0));
        when(productService.getProductByCode('C')).thenReturn(new Product("C", 20, 0, 0));

        String basket = "AAAABBBCCC";

        double expectedBasketValue = 315;
        assertEquals(expectedBasketValue, basketService.calculateBasketValue(basket));
    }

    @Test
    void shouldCalculateBasketValueWithMixedSpecialsAndRegularPrices() {
        List<Product> products = Arrays.asList(
                new Product("A", 1.25, 3, 3.00),
                new Product("B", 4.25, 0, 0),
                new Product("C", 1.00, 6, 5.00),
                new Product("D", 0.75, 0, 0)
        );
        when(productService.getAllProducts()).thenReturn(products);
        when(productService.getProductByCode('A')).thenReturn(new Product("A", 1.25, 3, 3.00));
        when(productService.getProductByCode('B')).thenReturn(new Product("B", 4.25, 0, 0));
        when(productService.getProductByCode('C')).thenReturn(new Product("C", 1.00, 6, 5.00));
        when(productService.getProductByCode('D')).thenReturn(new Product("D", 0.75, 0, 0));

        String basket = "ABCDABA";

        double expectedBasketValue = 13.25;
        assertEquals(expectedBasketValue, basketService.calculateBasketValue(basket));
    }

    @Test
    void shouldThrowExceptionForUnknownProductCode() {
        List<Product> products = Arrays.asList(
                new Product("A", 50, 3, 130),
                new Product("B", 30, 2, 45),
                new Product("C", 20, 0, 0)
        );
        when(productService.getAllProducts()).thenReturn(products);
        when(productService.getProductByCode('A')).thenReturn(new Product("A", 50, 0, 0));
        when(productService.getProductByCode('B')).thenReturn(new Product("B", 30, 0, 0));
        when(productService.getProductByCode('C')).thenReturn(new Product("C", 20, 0, 0));
        when(productService.getProductByCode('X')).thenReturn(null);

        String basketWithUnknownProductCode = "AAABBCX";

        assertThrows(RuntimeException.class, () -> basketService.calculateBasketValue(basketWithUnknownProductCode));
    }

}
