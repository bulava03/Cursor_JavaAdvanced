package com.example.Cursor_HW_110.service;

import com.example.Cursor_HW_110.entity.dto.CourseNoListDTO;
import com.example.Cursor_HW_110.entity.dto.StudentDTO;
import com.example.Cursor_HW_110.entity.dto.StudentShortedListDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StudentService {

    StudentDTO createStudent(StudentDTO studentDTO);

    ResponseEntity<StudentShortedListDTO> getStudentById(Long id);

    List<CourseNoListDTO> getCoursesByStudent(Long studentId);

    StudentShortedListDTO addCourseToStudent(Long studentId, Long courseId);

}
