package com.rismy.FoE_RoomReservation.service.impl;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.rismy.FoE_RoomReservation.dto.LoginRequestDto;
import com.rismy.FoE_RoomReservation.dto.RegisterRequestDto;
import com.rismy.FoE_RoomReservation.dto.ResponseDto;
import com.rismy.FoE_RoomReservation.exception.CustomException;
import com.rismy.FoE_RoomReservation.model.User;
import com.rismy.FoE_RoomReservation.model.User.AuthProvider;
import com.rismy.FoE_RoomReservation.model.User.UserType;
import com.rismy.FoE_RoomReservation.repository.UserRepository;
import com.rismy.FoE_RoomReservation.utils.Utils;

@Service
public class AuthServiceImpl {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	private final JwtTokenProvider jwtTokenProvider;

	public AuthServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder,
			JwtTokenProvider jwtTokenProvider) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
		this.jwtTokenProvider = jwtTokenProvider;
	}

	public ResponseDto register(RegisterRequestDto req) {
		ResponseDto response = new ResponseDto();
		try {
			if (userRepository.existsByEmail(req.getEmail())) {
				throw new CustomException(req.getEmail() + " Already exists");
			}

			User user = new User();
			user.setFirstName(req.getFirstName());
			user.setLastName(req.getLastName());
			user.setEmail(req.getEmail());
			user.setUserType(UserType.regularUser);
			user.setAuthProvider(AuthProvider.LOCAL);
			user.setPasswordHash(passwordEncoder.encode(req.getPassword()));

			User saved = userRepository.save(user);

			var userDto = Utils.mapUserToUserDto(saved);
			String accessToken = jwtTokenProvider.generateAccessToken(userDto);
			String refreshToken = jwtTokenProvider.generateRefreshToken(userDto);

			response.setStatusCode(200);
			response.setMessage("Registered successfully");
			response.setUser(userDto);
			response.setToken(accessToken);
			// refresh token returned separately by controller via HttpOnly cookie
			return response;
		} catch (CustomException e) {
			response.setStatusCode(409);
			response.setMessage(e.getMessage());
		} catch (Exception e) {
			response.setStatusCode(500);
			response.setMessage("Error occurred during registration: " + e.getMessage());
		}
		return response;
	}

	public ResponseDto login(LoginRequestDto req) {
		ResponseDto response = new ResponseDto();
		try {
			User user = userRepository.findByEmail(req.getEmail())
					.orElseThrow(() -> new BadCredentialsException("Invalid credentials"));

			if (user.getPasswordHash() == null || user.getPasswordHash().isBlank()) {
				throw new BadCredentialsException("Use Google login for this account");
			}
			if (!passwordEncoder.matches(req.getPassword(), user.getPasswordHash())) {
				throw new BadCredentialsException("Invalid credentials");
			}

			var userDto = Utils.mapUserToUserDto(user);
			String accessToken = jwtTokenProvider.generateAccessToken(userDto);

			response.setStatusCode(200);
			response.setMessage("Login successful");
			response.setUser(userDto);
			response.setToken(accessToken);
			return response;

		} catch (BadCredentialsException e) {
			response.setStatusCode(401);
			response.setMessage(e.getMessage());
		} catch (Exception e) {
			response.setStatusCode(500);
			response.setMessage("Error occurred during login: " + e.getMessage());
		}
		return response;
	}
}
