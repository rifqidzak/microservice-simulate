package com.example.microservice.userservice.service.implementation.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.microservice.core.dto.BaseGetResData;
import com.example.microservice.userservice.dao.declaration.GetAllUserDao;
import com.example.microservice.userservice.dto.GetUserDataDto;
import com.example.microservice.userservice.service.base.BaseUserService;
import com.example.microservice.userservice.service.declaration.user.GetAllUserService;

public class GetAllUserServiceImpl extends BaseUserService implements GetAllUserService{
	
	@Autowired
	private GetAllUserDao getAllUserDao;

	@Override
	public BaseGetResData<List<GetUserDataDto>> getAll() {
		return setToDto(getAllUserDao.getAll());
	}

}
