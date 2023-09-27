package com.example.Cursor_HW15.service.Impl;

import com.example.Cursor_HW15.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final com.example.Cursor_HW15.entity.User user = userRepository
                .findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("Користувача не знайдено"));
        return new User(user.getEmail(), user.getPassword(), Collections.emptyList());
    }

}
