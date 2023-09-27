package com.example.Cursor_HW_110.entity;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Embeddable
public class Name {

    @NotBlank(message = "Ім'я не може бути коротшим за 1 символ")
    String firstName;
    @NotBlank(message = "Прізвище не може бути коротшим за 1 символ")
    String lastName;

}
