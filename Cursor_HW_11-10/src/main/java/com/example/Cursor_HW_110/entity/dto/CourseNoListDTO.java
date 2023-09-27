package com.example.Cursor_HW_110.entity.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CourseNoListDTO {

    @NotBlank(message = "Назва повинна бути не коротше за 1 символ")
    private String name;

}
