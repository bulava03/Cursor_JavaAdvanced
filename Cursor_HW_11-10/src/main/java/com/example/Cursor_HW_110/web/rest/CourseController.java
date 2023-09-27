package com.example.Cursor_HW_110.web.rest;

import com.example.Cursor_HW_110.entity.dto.CourseDTO;
import com.example.Cursor_HW_110.exception.CourseNotFoundException;
import com.example.Cursor_HW_110.service.CourseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/course/*")
public class CourseController {

    @Autowired
    private CourseService courseService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public CourseDTO createCourse(@RequestBody @Validated CourseDTO courseDTO) {
        return courseService.createCourse(courseDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCourseById(@PathVariable Long id) {
        try{
            return courseService.getCourseById(id);
        } catch (CourseNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @DeleteMapping("/{courseId}/students/{studentId}")
    public ResponseEntity<Void> removeStudentFromCourse(@PathVariable Long courseId, @PathVariable Long studentId) {
        courseService.removeStudentFromCourse(courseId, studentId);
        return ResponseEntity.ok().build();
    }

}
