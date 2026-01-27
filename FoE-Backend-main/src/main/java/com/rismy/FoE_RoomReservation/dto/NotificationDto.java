package com.rismy.FoE_RoomReservation.dto;

import java.util.List;

public class NotificationDto {

	private UserDto loggedUser;
	private UserDto bookedByUser;
	private UserDto bookForUser;
	private String purpose;
	private List<String> bookingDates;
	private String startTime;
	private String endTime;
	private String roomName;

	public NotificationDto() {
	}

	public NotificationDto(UserDto loggedUser, UserDto bookedByUser, UserDto bookForUser, String purpose,
			List<String> bookingDates, String startTime, String endTime, String roomName) {
		this.loggedUser = loggedUser;
		this.bookedByUser = bookedByUser;
		this.bookForUser = bookForUser;
		this.purpose = purpose;
		this.bookingDates = bookingDates;
		this.startTime = startTime;
		this.endTime = endTime;
		this.roomName = roomName;
	}

	public UserDto getLoggedUser() {
		return loggedUser;
	}

	public void setLoggedUser(UserDto loggedUser) {
		this.loggedUser = loggedUser;
	}

	public UserDto getBookedByUser() {
		return bookedByUser;
	}

	public void setBookedByUser(UserDto bookedByUser) {
		this.bookedByUser = bookedByUser;
	}

	public UserDto getBookForUser() {
		return bookForUser;
	}

	public void setBookForUser(UserDto bookForUser) {
		this.bookForUser = bookForUser;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public List<String> getBookingDates() {
		return bookingDates;
	}

	public void setBookingDates(List<String> bookingDates) {
		this.bookingDates = bookingDates;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {
		private UserDto loggedUser;
		private UserDto bookedByUser;
		private UserDto bookForUser;
		private String purpose;
		private List<String> bookingDates;
		private String startTime;
		private String endTime;
		private String roomName;

		public Builder loggedUser(UserDto loggedUser) {
			this.loggedUser = loggedUser;
			return this;
		}

		public Builder bookedByUser(UserDto bookedByUser) {
			this.bookedByUser = bookedByUser;
			return this;
		}

		public Builder bookForUser(UserDto bookForUser) {
			this.bookForUser = bookForUser;
			return this;
		}

		public Builder purpose(String purpose) {
			this.purpose = purpose;
			return this;
		}

		public Builder bookingDates(List<String> bookingDates) {
			this.bookingDates = bookingDates;
			return this;
		}

		public Builder startTime(String startTime) {
			this.startTime = startTime;
			return this;
		}

		public Builder endTime(String endTime) {
			this.endTime = endTime;
			return this;
		}

		public Builder roomName(String roomName) {
			this.roomName = roomName;
			return this;
		}

		public NotificationDto build() {
			return new NotificationDto(loggedUser, bookedByUser, bookForUser, purpose, bookingDates, startTime, endTime,
					roomName);
		}
	}

	@Override
	public String toString() {
		return "NotificationDto{" + "loggedUser=" + loggedUser + ", bookedByUser=" + bookedByUser
				+ ", bookForUser=" + bookForUser + ", purpose='" + purpose + '\'' + ", bookingDates=" + bookingDates
				+ ", startTime='" + startTime + '\'' + ", endTime='" + endTime + '\'' + ", roomName='" + roomName
				+ '\'' + '}';
	}
}
