package com.example.Cursor_HW23_Producer2.web.rest;

import com.example.Cursor_HW23_Producer2.model.News;
import com.example.Cursor_HW23_Producer2.model.User;
import com.example.Cursor_HW23_Producer2.service.ProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/producer")
public class ProducerController {

    private final ProducerService producerService;

    @PostMapping("users")
    public void sendUser(@RequestBody User user) {
        producerService.sendMessage("producer2_names", user);
    }

    @PostMapping("news")
    public void sendNews(@RequestBody News news) {
        producerService.sendMessage("producer2_news", news);
    }

}
