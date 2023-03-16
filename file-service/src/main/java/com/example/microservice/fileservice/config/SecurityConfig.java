package com.example.microservice.fileservice.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.RequestMatcher;

import com.example.microservice.fileservice.filter.AuthorizationFilter;

@Configuration
public class SecurityConfig {
	@Bean
	public PasswordEncoder pwdEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean(name = "webIgnoring")
	public List<RequestMatcher> matchers() {
		final var matchers = new ArrayList<RequestMatcher>();
		return matchers;
	}

	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
		return (web) -> matchers().forEach(r -> web.ignoring().requestMatchers(r));
	}

	@Bean
	public SecurityFilterChain securityFilterChain(final HttpSecurity http,
			final AuthorizationFilter authorizationFilter) throws Exception {
		http.cors();
		http.csrf().disable();
		http.addFilterAt(authorizationFilter, UsernamePasswordAuthenticationFilter.class);
		return http.build();
	}
}
