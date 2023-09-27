package com.example.Cursor_HW12.service;

import com.example.Cursor_HW12.entity.Product;
import com.example.Cursor_HW12.service.impl.BasketServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BasketServiceImplTest {

    @InjectMocks
    private BasketServiceImpl basketService;

    @Mock
    private ProductService productService;

    private List<Product> getStandardProductsList() {
        List<Product> products = Arrays.asList(
                new Product("A", 50, 3, 130),
                new Product("B", 30, 2, 45),
                new Product("C", 20, 0, 0)
        );
        return products;
    }

    private void productsByCode(List<Product> products) {
        when(productService.getAllProducts()).thenReturn(products);
        when(productService.getProductByCode('A')).thenReturn(new Product("A", 50, 0, 0));
        when(productService.getProductByCode('B')).thenReturn(new Product("B", 30, 0, 0));
        when(productService.getProductByCode('C')).thenReturn(new Product("C", 20, 0, 0));
    }

    @Test
    void shouldCalculateBasketValueForEmptyString() {
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
        productsByCode(products);

        String basket = "AAABBC";

        double expectedBasketValue = 230;
        assertEquals(expectedBasketValue, basketService.calculateBasketValue(basket));
    }

    @Test
    void shouldCalculateBasketValueWithSpecialsExactMultiple() {
        List<Product> products = getStandardProductsList();
        productsByCode(products);

        String basket = "AAABBBCC";

        double expectedBasketValue = 245;
        assertEquals(expectedBasketValue, basketService.calculateBasketValue(basket));
    }

    @Test
    void shouldCalculateBasketValueWithSpecialsNotExactMultiple() {
        List<Product> products = getStandardProductsList();
        productsByCode(products);

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
        List<Product> products = getStandardProductsList();
        Mockito.lenient().when(productService.getAllProducts()).thenReturn(products);
        Mockito.lenient().when(productService.getProductByCode('A')).thenReturn(new Product("A", 50, 0, 0));
        Mockito.lenient().when(productService.getProductByCode('B')).thenReturn(new Product("B", 30, 0, 0));
        Mockito.lenient().when(productService.getProductByCode('C')).thenReturn(new Product("C", 20, 0, 0));
        Mockito.lenient().when(productService.getProductByCode('X')).thenReturn(null);

        String basketWithUnknownProductCode = "AAABBCX";

        assertThrows(RuntimeException.class, () -> basketService.calculateBasketValue(basketWithUnknownProductCode));
    }

}
