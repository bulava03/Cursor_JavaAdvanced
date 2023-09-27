package com.example.Cursor_HW12.web.rest;

import com.example.Cursor_HW12.service.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/basket")
public class BasketController {

    @Autowired
    private BasketService basketService;

    @GetMapping("/calculate/{basket}")
    public ResponseEntity<?> calculateBasketValue(@PathVariable String basket) {
        try {
            double totalCost = basketService.calculateBasketValue(basket);
            return ResponseEntity.ok(totalCost);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Під час виконання запиту сталася помилка");
        }
    }

}
