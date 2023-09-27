package com.example.Cursor_HW9.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String city;
    private String street;
    private String name;
    private int employees;
    private boolean hasWebsite;

    public Shop (String city, String street, String name, int employees, boolean hasWebsite) {
        this.city = city;
        this.street = street;
        this.name = name;
        this.employees = employees;
        this.hasWebsite = hasWebsite;
    }
}
