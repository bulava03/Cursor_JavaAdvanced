package com.example.Cursor_HW8.service.impl;

import com.example.Cursor_HW8.entity.Shop;
import com.example.Cursor_HW8.repository.ShopRepository;
import com.example.Cursor_HW8.service.ShopService;
import com.example.Cursor_HW8.service.exception.ShopException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopRepository shopRepository;

    @Override
    @Transactional
    public Shop createShop(Shop shop) {
        return shopRepository.save(shop);
    }

    @Override
    @Transactional
    public void deleteShop(Long id) {
        if (!shopRepository.existsById(id)) {
            throw new ShopException("Магазину з id " + id + " не знайдено");
        } else {
            shopRepository.deleteById(id);
        }
    }

    @Override
    public List<Shop> getAllShops() {
        Iterable<Shop> shopsIterable = shopRepository.findAll();
        List<Shop> list = new ArrayList<Shop>();
        for (Shop shop : shopsIterable) {
            list.add(shop);
        }
        if (list.size() == 0) {
            throw new ShopException("Список магазинів порожній");
        }
        return list;
    }

    public Shop getShopById(Long id) {
        return shopRepository.findById(id)
                .orElseThrow(() -> new ShopException("Магазину з id " + id + " не знайдено"));
    }

    @Override
    @Transactional
    public Shop updateShop(Long id, Shop shop) {
        Shop existingShop = shopRepository.findById(id)
                .orElseThrow(() -> new ShopException("Магазину з id " + id + " не знайдено"));
        try {
            existingShop.setCity(shop.getCity());
            existingShop.setStreet(shop.getStreet());
            existingShop.setName(shop.getName());
            existingShop.setEmployees(shop.getEmployees());
            existingShop.setHasWebsite(shop.isHasWebsite());
            return shopRepository.save(existingShop);
        } catch (Exception ex) {
            throw new ShopException("Виникла помилка під час зміни інформації про магазин");
        }
    }
}
