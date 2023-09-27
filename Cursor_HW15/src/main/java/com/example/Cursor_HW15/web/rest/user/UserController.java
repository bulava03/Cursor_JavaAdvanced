package com.example.Cursor_HW15.web.rest.user;

import com.example.Cursor_HW15.entity.dto.UserDTO;
import com.example.Cursor_HW15.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO create(@RequestBody @Validated UserDTO newUserDto) {
        return userService.create(newUserDto);
    }

    @GetMapping
    public List<UserDTO> getAll() {
        return userService.getAll();
    }

    @GetMapping("/user/{id}")
    public UserDTO getById(@PathVariable Long id) {
        return userService.get(id);
    }

    @DeleteMapping("/user/{id}")
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }
}
