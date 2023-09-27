package com.example.Cursor_HW_110.repository;

import com.example.Cursor_HW_110.entity.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {
}
