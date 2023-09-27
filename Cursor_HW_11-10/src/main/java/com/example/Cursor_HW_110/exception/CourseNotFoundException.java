package com.example.Cursor_HW_110.exception;

public class CourseNotFoundException extends RuntimeException {
    public CourseNotFoundException() {
        super("Курс не знайдено");
    }
}
