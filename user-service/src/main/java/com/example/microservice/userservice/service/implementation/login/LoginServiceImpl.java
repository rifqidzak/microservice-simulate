package com.example.microservice.userservice.service.implementation.login;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.microservice.userservice.dao.declaration.GetByEmailUserDao;
import com.example.microservice.userservice.model.User;
import com.example.microservice.userservice.service.declaration.login.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private GetByEmailUserDao getByEmailUserDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		final Optional<User> optionalUser = getByEmailUserDao.getByEmail(username);
		if (optionalUser.isPresent()) {
			return new org.springframework.security.core.userdetails.User(username, optionalUser.get().getPassword(),
					new ArrayList<>());
		}
		throw new RuntimeException("Your Email Not Registered");
	}

	@Override
	public Optional<User> getByEmail(String email) {
		return getByEmailUserDao.getByEmail(email);
	}

}
