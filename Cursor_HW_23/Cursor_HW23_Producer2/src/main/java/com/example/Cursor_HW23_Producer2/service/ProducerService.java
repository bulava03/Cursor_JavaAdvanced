package com.example.Cursor_HW23_Producer2.service;

public interface ProducerService {
    void sendMessage(String topic, Object message);
}
