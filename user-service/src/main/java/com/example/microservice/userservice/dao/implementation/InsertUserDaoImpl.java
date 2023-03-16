package com.example.microservice.userservice.dao.implementation;

import org.springframework.stereotype.Repository;

import com.example.microservice.userservice.dao.base.BaseUserDao;
import com.example.microservice.userservice.dao.declaration.InsertUserDao;
import com.example.microservice.userservice.model.User;
@Repository
public class InsertUserDaoImpl extends BaseUserDao implements InsertUserDao{

    @Override
    public User insert(User data) {
        return repository.save(data);
    }
    
}
