package com.example.Cursor_HW23_Consumer2.repository;

import com.example.Cursor_HW23_Consumer2.document.News;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NewsRepository extends MongoRepository<News, String> {
}
