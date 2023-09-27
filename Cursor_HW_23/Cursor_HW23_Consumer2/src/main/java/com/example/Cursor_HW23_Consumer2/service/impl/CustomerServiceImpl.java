package com.example.Cursor_HW23_Consumer2.service.impl;

import com.example.Cursor_HW23_Consumer2.document.News;
import com.example.Cursor_HW23_Consumer2.document.User;
import com.example.Cursor_HW23_Consumer2.repository.NewsRepository;
import com.example.Cursor_HW23_Consumer2.repository.UserRepository;
import com.example.Cursor_HW23_Consumer2.service.CustomerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final UserRepository userRepository;
    private final NewsRepository newsRepository;
    private final ObjectMapper objectMapper;

    @KafkaListener(topics = "producer1_names", groupId = "2")
    public void consumeFirstNames(String user) {
        try{
            User deserializedUser = objectMapper.readValue(user, User.class);
            userRepository.save(deserializedUser);
        } catch (JsonProcessingException e) {
            System.out.println(e);
        }
    }

    @KafkaListener(topics = "producer1_news", groupId = "2")
    public void consumeFirstNews(String news) {
        try{
            News deserializedNews = objectMapper.readValue(news, News.class);
            newsRepository.save(deserializedNews);
        } catch (JsonProcessingException e) {
            System.out.println(e);
        }
    }

    @KafkaListener(topics = "producer2_names", groupId = "2")
    public void consumeSecondNames(String user) {
        try{
            User deserializedUser = objectMapper.readValue(user, User.class);
            userRepository.save(deserializedUser);
        } catch (JsonProcessingException e) {
            System.out.println(e);
        }
    }

    @KafkaListener(topics = "producer2_news", groupId = "2")
    public void consumeSecondNews(String news) {
        try{
            News deserializedNews = objectMapper.readValue(news, News.class);
            newsRepository.save(deserializedNews);
        } catch (JsonProcessingException e) {
            System.out.println(e);
        }
    }
}
