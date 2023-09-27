package com.example.Cursor_HW_110.exception;

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException() {
        super("Студента не знайдено");
    }
}
