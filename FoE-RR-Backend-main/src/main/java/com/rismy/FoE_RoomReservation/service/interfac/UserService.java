package com.rismy.FoE_RoomReservation.service.interfac;

import org.springframework.security.core.Authentication;

import com.rismy.FoE_RoomReservation.dto.ResponseDto;
import com.rismy.FoE_RoomReservation.model.User;

public interface UserService {
		
	ResponseDto register(User user);

	ResponseDto getAllUsers();

	ResponseDto getUserById(long userId);

	ResponseDto deleteUser(long userId);

	ResponseDto getUserBookings(long userId);

	ResponseDto getUserbyFullName(String fullName);

	ResponseDto login(Authentication authentication);
}
