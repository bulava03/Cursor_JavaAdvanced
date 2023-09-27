package com.example.Cursor_HW_110.service;

import com.example.Cursor_HW_110.entity.dto.CourseDTO;
import com.example.Cursor_HW_110.entity.dto.CourseShortedListDTO;
import org.springframework.http.ResponseEntity;

public interface CourseService {

    CourseDTO createCourse(CourseDTO courseDTO);

    ResponseEntity<CourseShortedListDTO> getCourseById(Long id);

    void removeStudentFromCourse(Long courseId, Long studentId);

}
