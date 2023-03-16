package com.example.microservice.userservice.service.declaration.user;

import java.util.List;

import com.example.microservice.core.dto.BaseGetResData;
import com.example.microservice.userservice.dto.GetUserDataDto;

public interface GetAllUserService {
	BaseGetResData<List<GetUserDataDto>> getAll();
}
