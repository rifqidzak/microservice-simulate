package com.example.microservice.userservice.service.declaration.login;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.microservice.userservice.model.User;

public interface LoginService extends UserDetailsService {
	Optional<User> getByEmail(String email);
}
