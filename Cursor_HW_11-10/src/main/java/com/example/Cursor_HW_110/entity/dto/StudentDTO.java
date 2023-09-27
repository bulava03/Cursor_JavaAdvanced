package com.example.Cursor_HW_110.entity.dto;

import com.example.Cursor_HW_110.entity.Course;
import com.example.Cursor_HW_110.entity.Name;
import jakarta.validation.constraints.Email;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class StudentDTO {

    private Name name;
    @Email(message = "Неправильний email")
    private String email;
    private List<Course> courseList;

    public StudentDTO() {
        this.courseList = new ArrayList<Course>();
    }

}
