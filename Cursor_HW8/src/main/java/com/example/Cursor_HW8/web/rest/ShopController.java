package com.example.Cursor_HW8.web.rest;

import com.example.Cursor_HW8.entity.Shop;
import com.example.Cursor_HW8.service.ShopService;
import com.example.Cursor_HW8.service.exception.ShopException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ShopController {

    @Autowired
    private ShopService shopService;

    @PostMapping("/shops")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> createShop(@RequestBody Shop shop) {
        try {
            Shop createdShop = shopService.createShop(shop);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdShop);
        } catch (ShopException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @DeleteMapping("/shops/{id}")
    public ResponseEntity<?> deleteShop(@PathVariable Long id) {
        try {
            shopService.deleteShop(id);
            return ResponseEntity.noContent().build();
        } catch (ShopException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @GetMapping("/shops")
    public ResponseEntity<?> getAllShops() {
        try {
            List<Shop> shops = shopService.getAllShops();
            return ResponseEntity.ok(shops);
        } catch (ShopException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @GetMapping("/shops/{id}")
    public ResponseEntity<?> getShopById(@PathVariable Long id) {
        try {
            Shop shop = shopService.getShopById(id);
            return ResponseEntity.ok(shop);
        } catch (ShopException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @PutMapping("/shops/{id}")
    public ResponseEntity<?> updateShop(@PathVariable Long id, @RequestBody Shop shop) {
        try {
            Shop updatedShop = shopService.updateShop(id, shop);
            return ResponseEntity.ok(updatedShop);
        } catch (ShopException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

}
