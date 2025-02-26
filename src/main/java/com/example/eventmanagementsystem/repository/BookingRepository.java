package com.example.eventmanagementsystem.repository;

import com.example.eventmanagementsystem.model.Booking;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
    @Modifying
    @Transactional
    @Query("DELETE from Booking booking where booking.person.id = :userId AND booking.eventId = :eventId")
    int deleteBooking(int userId, int eventId);
}
