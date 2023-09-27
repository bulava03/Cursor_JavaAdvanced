package com.example.Cursor_HW_110.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToMany(mappedBy = "courseList")
    private List<Student> studentList;

    public Course() {
        this.studentList = new ArrayList<Student>();
    }

}
