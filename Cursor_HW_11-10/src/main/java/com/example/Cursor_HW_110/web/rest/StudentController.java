package com.example.Cursor_HW_110.web.rest;

import com.example.Cursor_HW_110.entity.dto.CourseNoListDTO;
import com.example.Cursor_HW_110.entity.dto.StudentDTO;
import com.example.Cursor_HW_110.entity.dto.StudentShortedListDTO;
import com.example.Cursor_HW_110.exception.StudentNotFoundException;
import com.example.Cursor_HW_110.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student/*")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public StudentDTO createStudent(@RequestBody @Validated StudentDTO studentDTO) {
        return studentService.createStudent(studentDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable Long id) {
        try {
            return studentService.getStudentById(id);
        } catch (StudentNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @GetMapping("/{id}/courses")
    public ResponseEntity<?> getCoursesByStudent(@PathVariable Long id) {
        try {
            List<CourseNoListDTO> courses = studentService.getCoursesByStudent(id);
            return ResponseEntity.ok(courses);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Під час виконання запиту сталася помилка");
        }
    }

    @PostMapping("/{studentId}/courses/{courseId}")
    public StudentShortedListDTO addCourseToStudent(@PathVariable Long studentId, @PathVariable Long courseId) {
        return studentService.addCourseToStudent(studentId, courseId);
    }

}
