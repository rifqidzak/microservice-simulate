package com.example.microservice.userservice.dao.declaration;

import java.util.List;

import com.example.microservice.userservice.model.User;

public interface GetAllUserDao {
    List<User>getAll();
}
