package com.example.eventmanagementsystem.controller;

import com.example.eventmanagementsystem.model.Event;
import com.example.eventmanagementsystem.service.CommonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommonController {
    private final CommonService commonService;

    public CommonController(CommonService commonService) {
        this.commonService = commonService;
    }

    @GetMapping("/getAllEvents")
    public ResponseEntity<List<Event>> getAllEvents() {
        return new ResponseEntity<>(commonService.getAllEvents(), HttpStatus.OK);
    }

    @GetMapping("/getEventById/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable int id) {
        return new ResponseEntity<>(commonService.getEventById(id), HttpStatus.OK);
    }
}
