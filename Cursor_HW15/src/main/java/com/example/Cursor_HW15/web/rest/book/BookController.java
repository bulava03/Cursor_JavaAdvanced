package com.example.Cursor_HW15.web.rest.book;

import com.example.Cursor_HW15.entity.dto.BookDTO;
import com.example.Cursor_HW15.exception.BookNotFoundException;
import com.example.Cursor_HW15.service.BookService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public ResponseEntity<List<BookDTO>> getAllBooks() {
        return new ResponseEntity<>(bookService.getAllBooks(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBookById(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(bookService.getBookById(id), HttpStatus.OK);
        } catch (BookNotFoundException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<BookDTO> createBook(@RequestBody @Valid BookDTO bookDTO) {
        if (bookDTO == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        BookDTO savedBook = bookService.addBook(bookDTO);
        return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.removeBook(id);
    }

}
