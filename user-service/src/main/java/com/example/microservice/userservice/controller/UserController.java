package com.example.microservice.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.microservice.core.dto.BasePostResDto;
import com.example.microservice.userservice.dto.PostUserDataDto;
import com.example.microservice.userservice.service.declaration.user.InsertUserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private InsertUserService insertUserService;

	@PostMapping
	ResponseEntity<BasePostResDto> insert(@RequestBody PostUserDataDto data) {
		BasePostResDto result = new BasePostResDto();
		result = insertUserService.insert(data);
		return new ResponseEntity<>(result, HttpStatus.CREATED);
	}

}
