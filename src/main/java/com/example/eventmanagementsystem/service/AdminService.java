package com.example.eventmanagementsystem.service;

import com.example.eventmanagementsystem.model.Event;
import com.example.eventmanagementsystem.repository.EventRepository;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    private final EventRepository eventRepository;

    public AdminService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public Event addEvent(Event event) {
        return eventRepository.save(event);
    }

    public Event updateEvent(int id, Event event) {
        event.setId(id);
        return eventRepository.save(event);
    }

    public String deleteEvent(int id) {
        eventRepository.deleteById(id);
        return "Event deleted";
    }
}
