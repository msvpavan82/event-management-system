package com.example.eventmanagementsystem.repository;

import com.example.eventmanagementsystem.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

}
