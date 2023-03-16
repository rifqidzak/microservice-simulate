package com.example.microservice.userservice.dao.base;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.microservice.core.dao.BaseEntityManager;
import com.example.microservice.userservice.repository.UserRepository;

public class BaseUserDao extends BaseEntityManager{
    @Autowired
    protected UserRepository repository;
}
