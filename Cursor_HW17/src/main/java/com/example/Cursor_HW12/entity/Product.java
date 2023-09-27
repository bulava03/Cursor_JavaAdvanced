package com.example.Cursor_HW12.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    private String code;
    private double price;
    private int specialQuantity;
    private double specialPrice;

    public Product (double price, int specialQuantity, double specialPrice) {
        this.price = price;
        this.specialQuantity = specialQuantity;
        this.specialPrice = specialPrice;
    }

}
