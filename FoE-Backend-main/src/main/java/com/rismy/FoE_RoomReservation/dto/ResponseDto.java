package com.rismy.FoE_RoomReservation.dto;

import java.util.List;

import com.rismy.FoE_RoomReservation.model.User.UserType;

public class ResponseDto {

	private int StatusCode;
	private String message;
	private String token;

	private UserType userType;
	private long userId;

	private UserDto user;
	private RoomDto room;
	private BookingDto booking;

	private List<UserDto> userList;
	private List<RoomDto> roomList;
	private List<BookingDto> bookingList;

	public ResponseDto() {
	}

	public ResponseDto(int statusCode, String message, String token, UserType userType, long userId, UserDto user,
			RoomDto room, BookingDto booking, List<UserDto> userList, List<RoomDto> roomList,
			List<BookingDto> bookingList) {
		this.StatusCode = statusCode;
		this.message = message;
		this.token = token;
		this.userType = userType;
		this.userId = userId;
		this.user = user;
		this.room = room;
		this.booking = booking;
		this.userList = userList;
		this.roomList = roomList;
		this.bookingList = bookingList;
	}

	public int getStatusCode() {
		return StatusCode;
	}

	public void setStatusCode(int statusCode) {
		StatusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public UserDto getUser() {
		return user;
	}

	public void setUser(UserDto user) {
		this.user = user;
	}

	public RoomDto getRoom() {
		return room;
	}

	public void setRoom(RoomDto room) {
		this.room = room;
	}

	public BookingDto getBooking() {
		return booking;
	}

	public void setBooking(BookingDto booking) {
		this.booking = booking;
	}

	public List<UserDto> getUserList() {
		return userList;
	}

	public void setUserList(List<UserDto> userList) {
		this.userList = userList;
	}

	public List<RoomDto> getRoomList() {
		return roomList;
	}

	public void setRoomList(List<RoomDto> roomList) {
		this.roomList = roomList;
	}

	public List<BookingDto> getBookingList() {
		return bookingList;
	}

	public void setBookingList(List<BookingDto> bookingList) {
		this.bookingList = bookingList;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {
		private final ResponseDto target = new ResponseDto();

		public Builder statusCode(int statusCode) {
			target.setStatusCode(statusCode);
			return this;
		}

		public Builder message(String message) {
			target.setMessage(message);
			return this;
		}

		public Builder token(String token) {
			target.setToken(token);
			return this;
		}

		public Builder userType(UserType userType) {
			target.setUserType(userType);
			return this;
		}

		public Builder userId(long userId) {
			target.setUserId(userId);
			return this;
		}

		public Builder user(UserDto user) {
			target.setUser(user);
			return this;
		}

		public Builder room(RoomDto room) {
			target.setRoom(room);
			return this;
		}

		public Builder booking(BookingDto booking) {
			target.setBooking(booking);
			return this;
		}

		public Builder userList(List<UserDto> userList) {
			target.setUserList(userList);
			return this;
		}

		public Builder roomList(List<RoomDto> roomList) {
			target.setRoomList(roomList);
			return this;
		}

		public Builder bookingList(List<BookingDto> bookingList) {
			target.setBookingList(bookingList);
			return this;
		}

		public ResponseDto build() {
			return target;
		}
	}

	@Override
	public String toString() {
		return "ResponseDto{" + "StatusCode=" + StatusCode + ", message='" + message + '\'' + ", token='" + token
				+ '\'' + ", userType=" + userType + ", userId=" + userId + ", user=" + user + ", room=" + room
				+ ", booking=" + booking + ", userList=" + userList + ", roomList=" + roomList + ", bookingList="
				+ bookingList + '}';
	}
}
