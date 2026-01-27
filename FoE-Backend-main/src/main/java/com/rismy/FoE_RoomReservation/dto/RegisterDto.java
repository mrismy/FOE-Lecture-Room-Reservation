package com.rismy.FoE_RoomReservation.dto;

import com.rismy.FoE_RoomReservation.model.User.UserType;

public class RegisterDto {

	private long userId;
	private String email;
	private long phoneNo;
	private String userName;
	private String password;
	private UserType userType;

	public RegisterDto() {
	}

	public RegisterDto(long userId, String email, long phoneNo, String userName, String password, UserType userType) {
		this.userId = userId;
		this.email = email;
		this.phoneNo = phoneNo;
		this.userName = userName;
		this.password = password;
		this.userType = userType;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {
		private long userId;
		private String email;
		private long phoneNo;
		private String userName;
		private String password;
		private UserType userType;

		public Builder userId(long userId) {
			this.userId = userId;
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

		public Builder userName(String userName) {
			this.userName = userName;
			return this;
		}

		public Builder password(String password) {
			this.password = password;
			return this;
		}

		public Builder userType(UserType userType) {
			this.userType = userType;
			return this;
		}

		public RegisterDto build() {
			return new RegisterDto(userId, email, phoneNo, userName, password, userType);
		}
	}

	@Override
	public String toString() {
		return "RegisterDto{" + "userId=" + userId + ", email='" + email + '\'' + ", phoneNo=" + phoneNo
				+ ", userName='" + userName + '\'' + ", password='" + (password == null ? null : "***") + '\''
				+ ", userType=" + userType + '}';
	}
}
