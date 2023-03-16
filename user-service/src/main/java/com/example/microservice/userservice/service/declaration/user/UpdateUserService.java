package com.example.microservice.userservice.service.declaration.user;

import com.example.microservice.core.dto.BasePutResDto;
import com.example.microservice.userservice.dto.PutUserDataDto;

public interface UpdateUserService {
	BasePutResDto update(PutUserDataDto data);
}
