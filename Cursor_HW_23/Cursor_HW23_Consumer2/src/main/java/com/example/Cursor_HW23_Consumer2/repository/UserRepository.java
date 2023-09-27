package com.example.Cursor_HW23_Consumer2.repository;

import com.example.Cursor_HW23_Consumer2.document.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
