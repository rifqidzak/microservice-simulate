package com.example.microservice.userservice.dao.implementation;

import org.springframework.stereotype.Repository;

import com.example.microservice.userservice.dao.base.BaseUserDao;
import com.example.microservice.userservice.dao.declaration.UpdateUserDao;
import com.example.microservice.userservice.model.User;
@Repository
public class UpdateUserDaoImpl extends BaseUserDao implements UpdateUserDao{

    @Override
    public User update(User data) {
        return repository.saveAndFlush(data);
    }
    
}
