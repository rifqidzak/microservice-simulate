package com.example.microservice.userservice.service.declaration.jwt;

import java.util.Map;

public interface JwtService {
	String generateJwt(Map<String, Object> claims);
}
