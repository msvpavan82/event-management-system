package com.example.eventmanagementsystem.controller;

import com.example.eventmanagementsystem.model.Booking;
import com.example.eventmanagementsystem.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/bookEvent/{userId}")
    public ResponseEntity<String> bookEvent(@PathVariable int userId, @RequestBody Booking booking) {
        return new ResponseEntity<>(userService.bookEvent(userId, booking), HttpStatus.OK);
    }
}
