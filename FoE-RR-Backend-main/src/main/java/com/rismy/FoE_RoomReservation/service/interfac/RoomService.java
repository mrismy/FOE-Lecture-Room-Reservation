package com.rismy.FoE_RoomReservation.service.interfac;

import java.sql.Date;

import com.rismy.FoE_RoomReservation.dto.ResponseDto;

public interface RoomService {

	ResponseDto getAllRooms();
	
	ResponseDto getRoomById(long roomId);
	
//	ResponseDto getAvailableRoomsByDate(Time startTime, Time endTime, Date date);
	
	ResponseDto addRoom(int capacity, String roomName, String description,boolean isOnlyBookedByAdmin);
	
	ResponseDto deleteRoom(long roomId);
	
	ResponseDto updateRoom(long roomId, Integer capacity, String roomName, String description);

	ResponseDto getAvailableRoomsByDate(Date date);
}
