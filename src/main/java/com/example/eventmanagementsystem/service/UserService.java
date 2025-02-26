package com.example.eventmanagementsystem.service;

import com.example.eventmanagementsystem.model.Booking;
import com.example.eventmanagementsystem.model.Person;
import com.example.eventmanagementsystem.repository.BookingRepository;
import com.example.eventmanagementsystem.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final BookingRepository bookingRepository;
    private final Booking booking;

    public UserService(UserRepository userRepository, BookingRepository bookingRepository, Booking booking) {
        this.userRepository = userRepository;
        this.bookingRepository = bookingRepository;
        this.booking = booking;
    }

    public String bookEvent(int userId, Booking booking) {
        if(userId == userRepository.findById(userId).orElse(new Person()).getId()) {
            booking.setPerson(userRepository.findById(userId).orElse(new Person()));

//            Checking if the user already booked the same event
            int existingEventId = -1;
            List<Booking> bookingList = bookingRepository.findAll();
            for(Booking booking1 : bookingList) {
                if(booking1.getPerson().getId() == userId) {
                    existingEventId = booking1.getEventId();
                }
            }

            if(booking.getEventId() == existingEventId)
                return "You have already booked the ticket for this event!!";

            bookingRepository.save(booking);
            return "Booked the event successfully!";
        }
        return "Failed to book the tickets";
    }

    public String cancelBooking(int userId, int eventId) {
        if(bookingRepository.deleteBooking(userId, eventId) == 1) {
            return "You have cancelled your booking";
        }
        return "You don't have a booking to cancel";
    }
}
