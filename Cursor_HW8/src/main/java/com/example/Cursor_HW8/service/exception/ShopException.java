package com.example.Cursor_HW8.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ShopException extends RuntimeException {
    public ShopException(String message) {
        super(message);
    }
}
