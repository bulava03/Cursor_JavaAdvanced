package com.example.Cursor_HW15.repository;

import com.example.Cursor_HW15.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findByEmail(String email);

}
