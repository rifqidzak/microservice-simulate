package com.example.microservice.userservice.service.implementation.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.microservice.core.dto.BasePostResDto;
import com.example.microservice.userservice.dao.declaration.InsertUserDao;
import com.example.microservice.userservice.dto.PostUserDataDto;
import com.example.microservice.userservice.model.User;
import com.example.microservice.userservice.service.base.BaseUserService;
import com.example.microservice.userservice.service.declaration.user.InsertUserService;

@Service
public class InsertUserServiceImpl extends BaseUserService implements InsertUserService {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private InsertUserDao insertUserDao;

	@Override
	public BasePostResDto insert(PostUserDataDto data) {
		User userInsert = new User();
		userInsert.setEmail(data.getEmail());
		userInsert.setName(data.getName());
		final String hashPwd = passwordEncoder.encode(data.getPassword());
		userInsert.setPassword(hashPwd);
		userInsert = insertUserDao.insert(userInsert);
		return setToPostRes(userInsert.getId());
	}

}
