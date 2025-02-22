package com.example.eventmanagementsystem.service;

import com.example.eventmanagementsystem.model.Event;
import com.example.eventmanagementsystem.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommonService {
    private final EventRepository eventRepository;

    public CommonService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Event getEventById(int id) {
        return eventRepository.findById(id).orElse(new Event());
    }
}
