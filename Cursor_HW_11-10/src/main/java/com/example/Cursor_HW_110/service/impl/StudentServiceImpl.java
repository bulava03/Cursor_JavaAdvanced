package com.example.Cursor_HW_110.service.impl;

import com.example.Cursor_HW_110.entity.Course;
import com.example.Cursor_HW_110.entity.Student;
import com.example.Cursor_HW_110.entity.dto.CourseNoListDTO;
import com.example.Cursor_HW_110.entity.dto.StudentDTO;
import com.example.Cursor_HW_110.entity.dto.StudentShortedListDTO;
import com.example.Cursor_HW_110.exception.CourseNotFoundException;
import com.example.Cursor_HW_110.exception.StudentNotFoundException;
import com.example.Cursor_HW_110.repository.CourseRepository;
import com.example.Cursor_HW_110.repository.StudentRepository;
import com.example.Cursor_HW_110.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private ModelMapper modelMapper;

    public StudentDTO createStudent(StudentDTO studentDTO) {
        Student newStudent = modelMapper.map(studentDTO, Student.class);
        studentRepository.save(newStudent);
        return studentDTO;
    }

    public ResponseEntity<StudentShortedListDTO> getStudentById(Long id) {
        return studentRepository.findById(id)
                .map(student -> modelMapper.map(student, StudentShortedListDTO.class))
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new StudentNotFoundException());
    }

    public List<CourseNoListDTO> getCoursesByStudent(Long studentId) {
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new StudentNotFoundException());
        List<CourseNoListDTO> courseDTOs = student.getCourseList().stream()
                .map(course -> modelMapper.map(course, CourseNoListDTO.class))
                .collect(Collectors.toList());
        return courseDTOs;
    }

    public StudentShortedListDTO addCourseToStudent(Long studentId, Long courseId) {
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new StudentNotFoundException());
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new CourseNotFoundException());
        List<Course> newCourseList = student.getCourseList();
        newCourseList.add(course);
        student.setCourseList(newCourseList);
        studentRepository.save(student);
        return modelMapper.map(student, StudentShortedListDTO.class);
    }

}
