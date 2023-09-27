package com.example.Cursor_HW15.service.Impl;

import com.example.Cursor_HW15.entity.User;
import com.example.Cursor_HW15.entity.dto.UserDTO;
import com.example.Cursor_HW15.exception.UserNotFoundException;
import com.example.Cursor_HW15.repository.UserRepository;
import com.example.Cursor_HW15.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDTO create(UserDTO userDto) {
        User user = modelMapper.map(userDto, User.class);
        String encodePassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodePassword);
        return modelMapper.map(userRepository.save(user), UserDTO.class);
    }

    @Override
    public List<UserDTO> getAll() {
        var users = (List<User>) userRepository.findAll();
        return users.stream()
                .map(user -> modelMapper.map(user, UserDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO get(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("Користувача не знайдено"));
        return modelMapper.map(user, UserDTO.class);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDTO getByEmail(String email) {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new UserNotFoundException("Користувача не знайдено"));
        return modelMapper.map(user, UserDTO.class);
    }

}
