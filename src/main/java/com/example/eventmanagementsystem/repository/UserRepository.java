package com.example.eventmanagementsystem.repository;

import com.example.eventmanagementsystem.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Person, Integer> {

}
