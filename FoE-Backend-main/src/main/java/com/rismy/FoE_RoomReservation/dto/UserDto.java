package com.rismy.FoE_RoomReservation.dto;

import java.util.ArrayList;
import java.util.List;

import com.rismy.FoE_RoomReservation.model.User.UserType;

public class UserDto {

	private long userId;
	private String firstName;
	private String lastName;
	private String email;
	private long phoneNo;
	private UserType userType;
	private List<BookingDto> bookings = new ArrayList<>();

	public UserDto() {
	}

	public UserDto(long userId, String firstName, String lastName, String email, long phoneNo, UserType userType,
			List<BookingDto> bookings) {
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNo = phoneNo;
		this.userType = userType;
		this.bookings = (bookings != null) ? bookings : new ArrayList<>();
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public List<BookingDto> getBookings() {
		return bookings;
	}

	public void setBookings(List<BookingDto> bookings) {
		this.bookings = (bookings != null) ? bookings : new ArrayList<>();
	}

	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {
		private long userId;
		private String firstName;
		private String lastName;
		private String email;
		private long phoneNo;
		private UserType userType;
		private List<BookingDto> bookings = new ArrayList<>();

		public Builder userId(long userId) {
			this.userId = userId;
			return this;
		}

		public Builder firstName(String firstName) {
			this.firstName = firstName;
			return this;
		}

		public Builder lastName(String lastName) {
			this.lastName = lastName;
			return this;
		}

		public Builder email(String email) {
			this.email = email;
			return this;
		}

		public Builder phoneNo(long phoneNo) {
			this.phoneNo = phoneNo;
			return this;
		}

		public Builder userType(UserType userType) {
			this.userType = userType;
			return this;
		}

		public Builder bookings(List<BookingDto> bookings) {
			this.bookings = (bookings != null) ? bookings : new ArrayList<>();
			return this;
		}

		public UserDto build() {
			return new UserDto(userId, firstName, lastName, email, phoneNo, userType, bookings);
		}
	}

	@Override
	public String toString() {
		return "UserDto{" + "userId=" + userId + ", firstName='" + firstName + '\'' + ", lastName='" + lastName
				+ '\'' + ", email='" + email + '\'' + ", phoneNo=" + phoneNo + ", userType=" + userType
				+ ", bookings=" + bookings + '}';
	}
}