package com.example.Cursor_HW15.service.Impl;

import com.example.Cursor_HW15.entity.Book;
import com.example.Cursor_HW15.entity.dto.BookDTO;
import com.example.Cursor_HW15.exception.BookNotFoundException;
import com.example.Cursor_HW15.repository.BookRepository;
import com.example.Cursor_HW15.service.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<BookDTO> getAllBooks() {
        List<Book> books = (List<Book>) bookRepository.findAll();
        return books.stream()
                .map(book -> modelMapper.map(book, BookDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public BookDTO getBookById(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException("Книгу не знайдено"));
        return modelMapper.map(book, BookDTO.class);
    }

    @Override
    public BookDTO addBook(BookDTO bookDTO) {
        Book book = modelMapper.map(bookDTO, Book.class);
        return modelMapper.map(bookRepository.save(book), BookDTO.class);
    }

    @Override
    public void removeBook(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException("Книгу не знайдено"));
        bookRepository.delete(book);
    }

}
