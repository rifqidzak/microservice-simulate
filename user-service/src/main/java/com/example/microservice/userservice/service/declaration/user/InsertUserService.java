package com.example.microservice.userservice.service.declaration.user;

import com.example.microservice.core.dto.BasePostResDto;
import com.example.microservice.userservice.dto.PostUserDataDto;

public interface InsertUserService {
	BasePostResDto insert(PostUserDataDto data);
}
