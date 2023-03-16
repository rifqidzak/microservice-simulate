package com.example.microservice.userservice.dao.implementation;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.microservice.userservice.dao.base.BaseUserDao;
import com.example.microservice.userservice.dao.declaration.GetAllUserDao;
import com.example.microservice.userservice.model.User;
@Repository
public class GetAllUserDaoImpl extends BaseUserDao implements GetAllUserDao{

    @Override
    public List<User> getAll() {
        return repository.findAll();
    }
   
}
