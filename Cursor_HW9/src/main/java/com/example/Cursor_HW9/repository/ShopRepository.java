package com.example.Cursor_HW9.repository;

import com.example.Cursor_HW9.entity.Shop;

import java.util.List;
import java.util.Optional;

public interface ShopRepository {

    List<Shop> findAll();

    Optional<Shop> findById(Long id);

    Shop save(Shop shop);

}
