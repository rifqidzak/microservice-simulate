package com.example.microservice.core.util;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.example.microservice.core.pojo.AuthorizationPojo;

@Component
public class AuthenticationUtil {

	public AuthorizationPojo getPrincipal() {
		final var authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication != null) {
			final var authorizationPojo = (AuthorizationPojo) authentication.getPrincipal();
			return authorizationPojo;
		}
		return null;
	}

}
