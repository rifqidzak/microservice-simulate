package com.example.microservice.fileservice.filter;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.microservice.core.pojo.AuthorizationPojo;
import com.example.microservice.core.util.JwtUtil;

@Component
public class AuthorizationFilter extends OncePerRequestFilter {
	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private List<RequestMatcher> matchers;

	@Override
	protected void doFilterInternal(final HttpServletRequest request, final HttpServletResponse response,
			final FilterChain filterChain) throws ServletException, IOException {
		final Long count = matchers.stream().filter((m) -> m.matches(request)).collect(Collectors.counting());
		if (!request.getRequestURI().equals("login") && count == 0) {
			final String authorization = request.getHeader("Authorization");

			if (authorization == null || authorization.length() < 8) {
				throw new RuntimeException("Invalid Token");
			}

			try {
				final String token = authorization.replaceFirst("Bearer ", "");
				final Map<String, Object> claims = jwtUtil.parseJwt(token);
				final AuthorizationPojo authorizationResDto = new AuthorizationPojo();
				authorizationResDto.setToken(token);
				authorizationResDto.setId(claims.get("id").toString());

				final Authentication auth = new UsernamePasswordAuthenticationToken(authorizationResDto, null);
				SecurityContextHolder.getContext().setAuthentication(auth);
			} catch (Exception e) {
				e.printStackTrace();
				response.setStatus(HttpStatus.UNAUTHORIZED.value());
				response.setContentType("application/json");
				return;
			}
		}
		filterChain.doFilter(request, response);
	}
}
