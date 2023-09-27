package com.example.Cursor_HW9.entity;

import com.example.Cursor_HW9.entity.Shop;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ShopDTO {
    private Long id;
    private String city;
    private String street;
    private String name;
    private boolean hasWebsite;

    public ShopDTO(Shop shop) {
        this.id = shop.getId();
        this.city = shop.getCity();
        this.street = shop.getStreet();
        this.name = shop.getName();
        this.hasWebsite = shop.isHasWebsite();
    }
}
