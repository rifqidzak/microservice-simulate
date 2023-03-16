package com.example.microservice.userservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.microservice.userservice.model.User;

public interface UserRepository extends JpaRepository<User,String>{

    Optional<User> findByEmail(String email);
    
}
