package com.example.Cursor_HW15.service;

import com.example.Cursor_HW15.entity.dto.BookDTO;

import java.util.List;

public interface BookService {

    List<BookDTO> getAllBooks();

    BookDTO getBookById(Long id);

    BookDTO addBook(BookDTO bookDTO);

    void removeBook(Long id);

}
