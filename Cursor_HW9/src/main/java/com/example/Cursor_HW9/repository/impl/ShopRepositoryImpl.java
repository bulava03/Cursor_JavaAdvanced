package com.example.Cursor_HW9.repository.impl;

import com.example.Cursor_HW9.repository.ShopRepository;

import com.example.Cursor_HW9.entity.Shop;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ShopRepositoryImpl implements ShopRepository {

    private static long maxId = 0L;
    private List<Shop> shops = new ArrayList<Shop>();

    public Shop save(Shop shop) {
        if (shop.getId() == null) {
            shop.setId(++maxId);
            shops.add(shop);
        } else {
            Optional<Shop> optionalShop = findById(shop.getId());
            if (optionalShop.isPresent()) {
                int index = shops.indexOf(optionalShop.get());
                shops.set(index, shop);
            } else {
                shop.setId(++maxId);
                shops.add(shop);
            }
        }
        return shop;
    }

    public List<Shop> findAll() {
        return shops;
    }

    public Optional<Shop> findById(Long id) {
        return shops.stream()
                .filter(shop -> shop.getId().equals(id))
                .findFirst();
    }

}
