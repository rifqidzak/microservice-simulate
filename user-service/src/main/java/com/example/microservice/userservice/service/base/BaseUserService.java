package com.example.microservice.userservice.service.base;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.microservice.core.dto.BaseGetResData;
import com.example.microservice.core.service.BaseService;
import com.example.microservice.userservice.dto.GetUserDataDto;
import com.example.microservice.userservice.model.User;

public class BaseUserService extends BaseService{
	protected BaseGetResData<List<GetUserDataDto>> setToDto(List<User> data) {
		final List<GetUserDataDto> dtos = new ArrayList<>();
		for (User user : data) {
			GetUserDataDto dto = setToDto(user);
			dtos.add(dto);
		}
		return setToBaseGetResData(dtos);
	}

	protected GetUserDataDto setToDto(User data) {
		final GetUserDataDto user = new GetUserDataDto();
			user.setId(data.getId());
			user.setEmail(data.getEmail());
			user.setName(data.getName());
		return user;
	}

	protected BaseGetResData<GetUserDataDto> setToDto(Optional<User> data) {
		final GetUserDataDto user = new GetUserDataDto();
		if (data.isPresent()) {
			User userData = new User();
			userData = data.get();
			if(userData.getFile()!=null) {
				user.setEmail(null);
			}
			user.setId(userData.getId());
			user.setEmail(userData.getEmail());
			user.setName(userData.getName());

		}
		return setToBaseGetResData(user);
	}

	private BaseGetResData<List<GetUserDataDto>> setToBaseGetResData(List<GetUserDataDto> dtos) {
		final BaseGetResData<List<GetUserDataDto>> baseGetResData = new BaseGetResData<>();
		baseGetResData.setData(dtos);
		return baseGetResData;
	}

	private BaseGetResData<GetUserDataDto> setToBaseGetResData(GetUserDataDto dto) {
		final BaseGetResData<GetUserDataDto> baseGetResData = new BaseGetResData<>();
		baseGetResData.setData(dto);
		return baseGetResData;
	}
}
