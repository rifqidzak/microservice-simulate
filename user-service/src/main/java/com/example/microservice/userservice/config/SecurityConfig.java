package com.example.microservice.userservice.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import com.example.microservice.userservice.filter.AuthorizationFilter;
import com.example.microservice.userservice.service.declaration.login.LoginService;

@Configuration
public class SecurityConfig {
	@Bean
	public PasswordEncoder pwdEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public AuthenticationManager authManager(final HttpSecurity http, final PasswordEncoder passwordEncoder,
			final LoginService loginService) throws Exception {
		return http.getSharedObject(AuthenticationManagerBuilder.class).userDetailsService(loginService)
				.passwordEncoder(passwordEncoder).and().build();
	}

	@Bean(name = "webIgnoring")
	public List<RequestMatcher> matchers() {
		final var matchers = new ArrayList<RequestMatcher>();
//		matchers.add(new AntPathRequestMatcher("/users", HttpMethod.POST.name()));
		matchers.add(new AntPathRequestMatcher("/login", HttpMethod.POST.name()));
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

//	@Bean
//	public WebMvcConfigurer webMvcConfigurer() {
//		return new WebMvcConfigurer() {
//			@Override
//			public void addCorsMappings(CorsRegistry registry) {
//				registry.addMapping("/**").allowedOrigins(OriginURL.URL_LOC.getUrl()).allowedMethods(
//						HttpMethod.GET.toString(), HttpMethod.POST.toString(), HttpMethod.PUT.toString(),
//						HttpMethod.PATCH.toString(), HttpMethod.DELETE.toString());
//				WebMvcConfigurer.super.addCorsMappings(registry);
//			}
//		};
//
//	}
}
