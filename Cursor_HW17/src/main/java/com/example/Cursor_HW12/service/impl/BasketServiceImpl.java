package com.example.Cursor_HW12.service.impl;

import com.example.Cursor_HW12.entity.Product;
import com.example.Cursor_HW12.service.BasketService;
import com.example.Cursor_HW12.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BasketServiceImpl implements BasketService {

    @Autowired
    private ProductService productService;

    @Override
    public double calculateBasketValue(String basket) {
        ifEveryTypeExists(basket);
        String sortedBasket = getSortedBasket(basket);
        Map<String, Integer> countedBasket = countLetters(sortedBasket);
        Map<Product, Double> countedPrices = calculatePrices(countedBasket, productService.getAllProducts());
        return getTotalPrice(countedPrices);
    }

    private void ifEveryTypeExists(String toCheck) {
        for (int i = 0; i < toCheck.length(); i++) {
            char id = toCheck.charAt(i);
            Product entity = productService.getProductByCode(id);
            if (entity == null) {
                throw new RuntimeException();
            }
        }
    }

    private String getSortedBasket(String basket) {
        char[] charArray = basket.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }

    private Map<String, Integer> countLetters(String str) {
        Map<String, Integer> counts = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            String c = str.substring(i, i+1);
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }
        return counts;
    }

    private Map<Product, Double> calculatePrices(Map<String, Integer> quantities, List<Product> products) {
        Map<Product, Double> prices = new HashMap<>();
        for (Product product : products) {
            int quantity = quantities.getOrDefault(product.getCode(), 0);
            if (product.getSpecialQuantity() == 0) {
                double price = quantity * product.getPrice();
                prices.put(product, price);
            } else {
                int specialQuantity = product.getSpecialQuantity();
                double specialPrice = product.getSpecialPrice();
                int numSpecials = quantity / specialQuantity;
                int remainingQuantity = quantity % specialQuantity;
                double price = numSpecials * specialPrice + remainingQuantity * product.getPrice();
                prices.put(product, price);
            }
        }
        return prices;
    }

    private double getTotalPrice(Map<Product, Double> prices) {
        double total = 0;
        for (double price : prices.values()) {
            total += price;
        }
        return total;
    }

}
