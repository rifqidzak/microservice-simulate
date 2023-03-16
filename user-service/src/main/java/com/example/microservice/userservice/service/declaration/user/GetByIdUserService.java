package com.example.microservice.userservice.service.declaration.user;

import com.example.microservice.core.dto.BaseGetResData;
import com.example.microservice.userservice.dto.GetUserDataDto;

public interface GetByIdUserService {
	BaseGetResData<GetUserDataDto> getById(String id);
}
