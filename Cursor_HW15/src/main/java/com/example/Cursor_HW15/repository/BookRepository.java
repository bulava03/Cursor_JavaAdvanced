package com.example.Cursor_HW15.repository;

import com.example.Cursor_HW15.entity.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
