package com.example.Cursor_HW16.web.rest;

import com.example.Cursor_HW16.document.dto.UserDTO;
import com.example.Cursor_HW16.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserDTO userDTO) {
        UserDTO createdUserDTO = userService.create(userDTO);
        return ResponseEntity.ok(createdUserDTO);
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<UserDTO>> getAll() {
        List<UserDTO> users = userService.findAll();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/get-by-first-name/{firstName}")
    public ResponseEntity<List<UserDTO>> getByFirstName(@PathVariable String firstName) {
        List<UserDTO> users = userService.findByFirstName(firstName);
        return ResponseEntity.ok(users);
    }

    @GetMapping("/get-by-last-name/{lastName}")
    public ResponseEntity<List<UserDTO>> getByLastName(@PathVariable String lastName) {
        List<UserDTO> users = userService.findByLastName(lastName);
        return ResponseEntity.ok(users);
    }

    @GetMapping("/get-by-email/{email}")
    public ResponseEntity<List<UserDTO>> getByEmail(@PathVariable String email) {
        List<UserDTO> users = userService.findByEmail(email);
        return ResponseEntity.ok(users);
    }

    @GetMapping("/get-older-than-18")
    public ResponseEntity<List<UserDTO>> getOlderThan18() {
        List<UserDTO> users = userService.findOlderThenEighteen();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/get-married")
    public ResponseEntity<List<UserDTO>> getMarried() {
        List<UserDTO> users = userService.findMarried();
        return ResponseEntity.ok(users);
    }

}
