package com.example.Cursor_HW16.service.impl;

import com.example.Cursor_HW16.document.User;
import com.example.Cursor_HW16.document.dto.UserDTO;
import com.example.Cursor_HW16.repository.UserRepository;
import com.example.Cursor_HW16.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDTO create(UserDTO userDTO) {
        User user = modelMapper.map(userDTO, User.class);
        User createdUser = userRepository.save(user);
        return modelMapper.map(createdUser, UserDTO.class);
    }

    @Override
    public List<UserDTO> findAll() {
        List<User> users = userRepository.findAll();
        if (users.isEmpty()) {
            throw new RuntimeException("No users found");
        }
        return users.stream()
                .map(user -> modelMapper.map(user, UserDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<UserDTO> findByFirstName(String firstName) {
        List<User> users = userRepository.findByFirstName(firstName);
        if (users.isEmpty()) {
            throw new RuntimeException("No users found");
        }
        return users.stream()
                .map(user -> modelMapper.map(user, UserDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<UserDTO> findByLastName(String lastName) {
        List<User> users = userRepository.findByLastName(lastName);
        if (users.isEmpty()) {
            throw new RuntimeException("No users found");
        }
        return users.stream()
                .map(user -> modelMapper.map(user, UserDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<UserDTO> findByEmail(String email) {
        List<User> users = userRepository.findByEmail(email);
        if (users.isEmpty()) {
            throw new RuntimeException("No users found");
        }
        return users.stream()
                .map(user -> modelMapper.map(user, UserDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<UserDTO> findOlderThenEighteen() {
        List<User> users = userRepository.findByAgeGreaterThan(18);
        if (users.isEmpty()) {
            throw new RuntimeException("No users found");
        }
        return users.stream()
                .map(user -> modelMapper.map(user, UserDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<UserDTO> findMarried() {
        List<User> users = userRepository.findByIsMarried(true);
        if (users.isEmpty()) {
            throw new RuntimeException("No users found");
        }
        return users.stream()
                .map(user -> modelMapper.map(user, UserDTO.class))
                .collect(Collectors.toList());
    }

}
