package com.example.Cursor_HW_110.service.impl;

import com.example.Cursor_HW_110.entity.Course;
import com.example.Cursor_HW_110.entity.Student;
import com.example.Cursor_HW_110.entity.dto.CourseDTO;
import com.example.Cursor_HW_110.entity.dto.CourseShortedListDTO;
import com.example.Cursor_HW_110.exception.CourseNotFoundException;
import com.example.Cursor_HW_110.exception.StudentNotFoundException;
import com.example.Cursor_HW_110.repository.CourseRepository;
import com.example.Cursor_HW_110.repository.StudentRepository;
import com.example.Cursor_HW_110.service.CourseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private ModelMapper modelMapper;

    public CourseDTO createCourse(CourseDTO courseDTO) {
        Course newCourse = modelMapper.map(courseDTO, Course.class);
        courseRepository.save(newCourse);
        return courseDTO;
    }

    public ResponseEntity<CourseShortedListDTO> getCourseById(Long id) {
        return courseRepository.findById(id)
                .map(course -> modelMapper.map(course, CourseShortedListDTO.class))
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new CourseNotFoundException());
    }

    public void removeStudentFromCourse(Long courseId, Long studentId) {
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new StudentNotFoundException());
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new CourseNotFoundException());

        List<Course> courses = student.getCourseList();
        List<Student> students = course.getStudentList();

        courses.remove(course);
        students.remove(student);

        studentRepository.save(student);
        courseRepository.save(course);
    }

}
