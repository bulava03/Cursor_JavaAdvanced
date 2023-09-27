package com.example.Cursor_HW23_Producer1.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class Config {

    @Bean
    public NewTopic producer1_names() {
        return TopicBuilder.name("producer1_names").build();
    }

    @Bean
    public NewTopic producer1_news() {
        return TopicBuilder.name("producer1_news").build();
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

}
