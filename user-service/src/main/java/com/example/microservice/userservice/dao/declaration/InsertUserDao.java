package com.example.microservice.userservice.dao.declaration;

import com.example.microservice.userservice.model.User;

public interface InsertUserDao {
    User insert(User data);
}
