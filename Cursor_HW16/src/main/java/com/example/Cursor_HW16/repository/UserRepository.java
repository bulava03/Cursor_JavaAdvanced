package com.example.Cursor_HW16.repository;

import com.example.Cursor_HW16.document.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    List<User> findByFirstName(String firstName);
    List<User> findByLastName(String lastName);
    List<User> findByEmail(String email);
    List<User> findByAgeGreaterThan(int age);
    List<User> findByIsMarried(boolean isMarried);

}
