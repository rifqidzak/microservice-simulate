package com.example.microservice.userservice.dao.implementation;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.microservice.userservice.dao.base.BaseUserDao;
import com.example.microservice.userservice.dao.declaration.GetByIdUserDao;
import com.example.microservice.userservice.model.User;
@Repository
public class GetByIdUserDaoImpl extends BaseUserDao implements GetByIdUserDao{

    @Override
    public Optional<User> getById(String id) {
        final Optional<User> optional = repository.findById(id);
        User user = new User();
        if(optional.isPresent()){
            user = optional.get();
            detach(user);
        }
        return Optional.ofNullable(user);
    }
    
}
