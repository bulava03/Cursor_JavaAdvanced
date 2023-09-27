package com.example.Cursor_HW16.service;

import com.example.Cursor_HW16.document.User;
import com.example.Cursor_HW16.document.dto.UserDTO;

import java.util.List;

public interface UserService {

    UserDTO create(UserDTO userDTO);
    List<UserDTO> findAll();
    List<UserDTO> findByFirstName(String firstName);
    List<UserDTO> findByLastName(String lastName);
    List<UserDTO> findByEmail(String email);
    List<UserDTO> findOlderThenEighteen();
    List<UserDTO> findMarried();

}
