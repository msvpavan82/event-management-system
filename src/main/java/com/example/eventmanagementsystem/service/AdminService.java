package com.example.eventmanagementsystem.service;

import com.example.eventmanagementsystem.model.Event;
import com.example.eventmanagementsystem.repository.AdminRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    private final AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public Event addEvent(Event event) {
        return adminRepository.save(event);
    }

    public List<Event> getAllEvents() {
        return adminRepository.findAll();
    }

    public Event updateEvent(int id, Event event) {
        event.setId(id);
        return adminRepository.save(event);
    }

    public String deleteEvent(int id) {
        adminRepository.deleteById(id);
        return "Event deleted";
    }

    public Event getEventById(int id) {
        return adminRepository.findById(id).orElse(new Event());
    }
}
