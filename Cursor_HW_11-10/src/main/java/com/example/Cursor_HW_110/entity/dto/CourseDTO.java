package com.example.Cursor_HW_110.entity.dto;

import com.example.Cursor_HW_110.entity.Student;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CourseDTO {

    @NotBlank(message = "Назва повинна бути не коротше за 1 символ")
    private String name;
    private List<Student> studentList;

    public CourseDTO() {
        this.studentList = new ArrayList<Student>();
    }

}
