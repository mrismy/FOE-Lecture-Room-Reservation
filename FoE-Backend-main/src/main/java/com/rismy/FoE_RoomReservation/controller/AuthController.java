package com.rismy.FoE_RoomReservation.controller;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rismy.FoE_RoomReservation.dto.LoginRequestDto;
import com.rismy.FoE_RoomReservation.dto.RegisterRequestDto;
import com.rismy.FoE_RoomReservation.dto.ResponseDto;
import com.rismy.FoE_RoomReservation.dto.UserDto;
import com.rismy.FoE_RoomReservation.repository.UserRepository;
import com.rismy.FoE_RoomReservation.service.impl.AuthServiceImpl;
import com.rismy.FoE_RoomReservation.service.impl.JwtTokenProvider;
import com.rismy.FoE_RoomReservation.service.impl.UserServiceImpl;

import jakarta.servlet.http.HttpServletResponse;

@CrossOrigin("5173")
@RestController
@RequestMapping("/auth")
public class AuthController {

	private final UserServiceImpl userService;
	private final JwtTokenProvider jwtTokenProvider;
	private final AuthServiceImpl authService;
	private final UserRepository userRepository;

	@Autowired
	public AuthController(UserServiceImpl userService, JwtTokenProvider jwtTokenProvider, AuthServiceImpl authService,
			UserRepository userRepository) {
		this.userService = userService;
		this.jwtTokenProvider = jwtTokenProvider;
		this.authService = authService;
		this.userRepository = userRepository;
	}

	@PostMapping("/register")
	public ResponseEntity<ResponseDto> register(@RequestBody RegisterRequestDto request, HttpServletResponse response) {
		ResponseDto res = authService.register(request);
		if (res.getStatusCode() != 200) {
			return ResponseEntity.status(res.getStatusCode()).body(res);
		}

		// set refresh cookie
		String refreshToken = jwtTokenProvider.generateRefreshToken(res.getUser());
		ResponseCookie cookie = ResponseCookie.from("refreshToken", refreshToken)
				.httpOnly(true)
				.secure(true)
				.path("/auth/refresh")
				.maxAge(jwtTokenProvider.getRefreshTokenExpiration() / 1000)
				.sameSite("Lax")
				.build();
		response.addHeader(HttpHeaders.SET_COOKIE, cookie.toString());
		return ResponseEntity.ok(res);
	}

	@PostMapping("/login")
	public ResponseEntity<ResponseDto> loginLocal(@RequestBody LoginRequestDto request, HttpServletResponse response) {
		ResponseDto res = authService.login(request);
		if (res.getStatusCode() != 200) {
			return ResponseEntity.status(res.getStatusCode()).body(res);
		}
		String refreshToken = jwtTokenProvider.generateRefreshToken(res.getUser());
		ResponseCookie cookie = ResponseCookie.from("refreshToken", refreshToken)
				.httpOnly(true)
				.secure(true)
				.path("/auth/refresh")
				.maxAge(jwtTokenProvider.getRefreshTokenExpiration() / 1000)
				.sameSite("Lax")
				.build();
		response.addHeader(HttpHeaders.SET_COOKIE, cookie.toString());
		return ResponseEntity.ok(res);
	}

	// Google OAuth login callback still uses /auth/me + /auth/refresh etc.
	@GetMapping("/me")
	public ResponseEntity<ResponseDto> getCurrentUser(@RequestHeader(HttpHeaders.AUTHORIZATION) String authHeader) {
		if (authHeader == null || !authHeader.startsWith("Bearer ")) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}

		String token = authHeader.substring(7);
		String email = jwtTokenProvider.getUsernameFromToken(token);
		return ResponseEntity.status(200).body(userService.getUserByEmail(email));
	}

	@GetMapping("/refresh")
	public ResponseEntity<ResponseDto> refresh(
			@CookieValue(name = "refreshToken", required = false) String oldRefreshToken,
			HttpServletResponse response) {

		if (oldRefreshToken == null) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}

		if (!jwtTokenProvider.validateToken(oldRefreshToken)) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}

		String username = jwtTokenProvider.getUsernameFromToken(oldRefreshToken);
		UserDto user = userService.getUserByEmail(username).getUser();

		UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
				user.getEmail(),
				null,
				Collections.singletonList(new SimpleGrantedAuthority(String.valueOf(user.getUserType()))));

		SecurityContextHolder.getContext().setAuthentication(authToken);

		String accessToken = jwtTokenProvider.generateAccessToken(user);
		String refreshToken = jwtTokenProvider.generateRefreshToken(user);

		ResponseCookie cookie = ResponseCookie.from("refreshToken", refreshToken)
				.httpOnly(true)
				.secure(true)
				.path("/auth/refresh")
				.maxAge(jwtTokenProvider.getRefreshTokenExpiration() / 1000)
				.sameSite("Lax")
				.build();
		response.addHeader(HttpHeaders.SET_COOKIE, cookie.toString());
		return ResponseEntity.ok(ResponseDto.builder().token(accessToken).build());
	}

	@PostMapping("/logout")
	public ResponseEntity<Void> logout(@CookieValue(name = "refreshToken", required = false) String refreshToken,
			HttpServletResponse response) {
		ResponseCookie cookie = ResponseCookie.from("refreshToken", "")
				.httpOnly(false)
				.secure(true)
				.path("/auth/refresh")
				.maxAge(0)
				.sameSite("Lax")
				.build();
		response.addHeader(HttpHeaders.SET_COOKIE, cookie.toString());
		return ResponseEntity.noContent().build();
	}
}