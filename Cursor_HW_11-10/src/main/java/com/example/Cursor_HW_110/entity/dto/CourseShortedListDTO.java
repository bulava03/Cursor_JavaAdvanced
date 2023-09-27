package com.example.Cursor_HW_110.entity.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CourseShortedListDTO {

    @NotBlank(message = "Назва повинна бути не коротше за 1 символ")
    private String name;
    private List<StudentNoListDTO> studentList;

    public CourseShortedListDTO() {
        this.studentList = new ArrayList<StudentNoListDTO>();
    }

}
