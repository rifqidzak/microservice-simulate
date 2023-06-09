package com.example.microservice.userservice.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.microservice.userservice.dto.auth.AuthorizationResDto;
import com.example.microservice.userservice.dto.login.LoginReqDto;
import com.example.microservice.userservice.service.declaration.jwt.JwtService;
import com.example.microservice.userservice.service.declaration.login.LoginService;

@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtService jwtService;

	@Autowired
	private LoginService loginService;

	@PostMapping
	public ResponseEntity<AuthorizationResDto> login(@RequestBody final LoginReqDto data) {
		String email = data.getEmail();
		String pw = data.getPassword();
		final Authentication auth = new UsernamePasswordAuthenticationToken(email, pw);
		authenticationManager.authenticate(auth);
		final Optional<com.example.microservice.userservice.model.User> user = loginService.getByEmail(email);
		final Map<String, Object> claims = new HashMap<>();
		final Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.HOUR_OF_DAY, 100);
		claims.put("exp", cal.getTime());
		claims.put("id", user.get().getId());

		final AuthorizationResDto loginResDto = new AuthorizationResDto();
		loginResDto.setId(user.get().getId());
		loginResDto.setToken(jwtService.generateJwt(claims));

		return new ResponseEntity<AuthorizationResDto>(loginResDto, HttpStatus.OK);
	}
}
