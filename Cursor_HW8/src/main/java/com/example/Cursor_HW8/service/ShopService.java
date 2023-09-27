package com.example.Cursor_HW8.service;

import com.example.Cursor_HW8.entity.Shop;

import java.util.List;

public interface ShopService {

    public Shop createShop(Shop shop);

    public void deleteShop(Long id);

    public List<Shop> getAllShops();

    public Shop getShopById(Long id);

    public Shop updateShop(Long id, Shop shop);

}
