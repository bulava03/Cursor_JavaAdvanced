package com.example.Cursor_HW15.service;

import com.example.Cursor_HW15.entity.dto.UserDTO;

import java.util.List;

public interface UserService {

    UserDTO create(UserDTO newUserDto);

    List<UserDTO> getAll();

    UserDTO get(Long id);

    void delete(Long id);

    UserDTO getByEmail(String email);

}
