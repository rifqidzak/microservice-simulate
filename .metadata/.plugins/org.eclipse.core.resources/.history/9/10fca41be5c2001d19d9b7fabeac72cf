package com.example.microservice.userservice.dao.implementation;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.microservice.userservice.dao.base.BaseUserDao;
import com.example.microservice.userservice.dao.declaration.GetByEmailUserDao;
import com.example.microservice.userservice.model.User;
@Repository
public class GetByEmailUserDaoImpl extends BaseUserDao implements GetByEmailUserDao{

    @Override
    public Optional<User> getByEmail(String email) {
        final Optional<User> optional = repository.findByEmail(email);
        User user = new User();
        if(optional.isPresent()){
            user = optional.get();
            detach(user);
        }
        return Optional.ofNullable(user);
    }
    
}
