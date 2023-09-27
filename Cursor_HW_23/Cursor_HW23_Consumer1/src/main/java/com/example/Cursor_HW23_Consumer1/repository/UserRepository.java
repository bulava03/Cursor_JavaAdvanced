package com.example.Cursor_HW23_Consumer1.repository;


import com.example.Cursor_HW23_Consumer1.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
