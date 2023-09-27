package com.example.Cursor_HW23_Consumer3.web.rest;

import com.example.Cursor_HW23_Consumer3.entity.News;
import com.example.Cursor_HW23_Consumer3.repository.NewsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/news")
public class NewsController {

    private final NewsRepository newsRepository;

    @GetMapping
    public ResponseEntity<List<News>> getAllNews() {
        List<News> newsList = newsRepository.findAll();
        return ResponseEntity.ok(newsList);
    }
}
