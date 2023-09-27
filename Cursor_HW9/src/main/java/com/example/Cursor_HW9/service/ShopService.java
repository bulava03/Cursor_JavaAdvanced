package com.example.Cursor_HW9.service;

import com.example.Cursor_HW9.entity.Shop;

import java.util.List;

public interface ShopService {

    public Shop createShop(Shop shop);

    public List<Shop> getAllShops();

    public Shop getShopById(Long id);

}
