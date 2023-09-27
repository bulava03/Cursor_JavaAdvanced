package com.example.Cursor_HW9.service.impl;

import com.example.Cursor_HW9.repository.impl.ShopRepositoryImpl;
import com.example.Cursor_HW9.service.ShopService;
import com.example.Cursor_HW9.entity.Shop;
import com.example.Cursor_HW9.repository.ShopRepository;
import com.example.Cursor_HW9.service.exception.ShopException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {

    private final ShopRepository shopRepository;

    public ShopServiceImpl() {
        this.shopRepository = new ShopRepositoryImpl();
    }

    @Override
    @Transactional
    public Shop createShop(Shop shop) {
        return shopRepository.save(shop);
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

}
