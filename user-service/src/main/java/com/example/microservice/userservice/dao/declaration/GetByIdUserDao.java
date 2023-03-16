package com.example.microservice.userservice.dao.declaration;

import java.util.Optional;

import com.example.microservice.userservice.model.User;

public interface GetByIdUserDao {
    Optional<User> getById(String id);
}
