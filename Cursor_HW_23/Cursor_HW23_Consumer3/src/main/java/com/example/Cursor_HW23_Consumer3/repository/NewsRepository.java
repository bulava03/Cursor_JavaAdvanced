package com.example.Cursor_HW23_Consumer3.repository;

import com.example.Cursor_HW23_Consumer3.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<News, Long> {
}
