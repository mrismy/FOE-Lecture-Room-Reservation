package com.rismy.FoE_RoomReservation.dto;

import java.util.List;

public class RoomDto {

	private long roomId;
	private int capacity;
	private String roomName;
	private String description;
	private List<BookingDto> bookings;

	public RoomDto() {
	}

	public RoomDto(long roomId, int capacity, String roomName, String description, List<BookingDto> bookings) {
		this.roomId = roomId;
		this.capacity = capacity;
		this.roomName = roomName;
		this.description = description;
		this.bookings = bookings;
	}

	public long getRoomId() {
		return roomId;
	}

	public void setRoomId(long roomId) {
		this.roomId = roomId;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<BookingDto> getBookings() {
		return bookings;
	}

	public void setBookings(List<BookingDto> bookings) {
		this.bookings = bookings;
	}

	@Override
	public String toString() {
		return "RoomDto{" + "roomId=" + roomId + ", capacity=" + capacity + ", roomName='" + roomName + '\''
				+ ", description='" + description + '\'' + ", bookings=" + bookings + '}';
	}
}
