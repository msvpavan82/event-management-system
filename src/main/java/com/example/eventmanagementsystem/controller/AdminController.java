package com.example.eventmanagementsystem.controller;

import com.example.eventmanagementsystem.model.Event;
import com.example.eventmanagementsystem.service.AdminService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/getAllEvents")
    public ResponseEntity<List<Event>> getAllEvents() {
        return new ResponseEntity<>(adminService.getAllEvents(), HttpStatus.OK);
    }

    @GetMapping("/getEventById/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable int id) {
        return new ResponseEntity<>(adminService.getEventById(id), HttpStatus.OK);
    }

    @PostMapping("/addEvent")
    public ResponseEntity<Event> addEvent(@RequestBody Event event) {
        return new ResponseEntity<>(adminService.addEvent(event), HttpStatus.CREATED);
    }

    @PutMapping("/updateEvent/{id}")
    public ResponseEntity<Event> updateEvent(@PathVariable int id, @RequestBody Event event) {
        return new ResponseEntity<>(adminService.updateEvent(id, event), HttpStatus.OK);
    }

    @DeleteMapping("/deleteEvent/{id}")
    public ResponseEntity<String> deleteEvent(@PathVariable int id) {
        return new ResponseEntity<>(adminService.deleteEvent(id), HttpStatus.OK);
    }
}
