package com.rismy.FoE_RoomReservation.dto;

import jakarta.validation.constraints.NotBlank;

public class LoginDto {

	@NotBlank(message = "user name is required")
	private String userName;
	@NotBlank(message = "password name is required")
	private String password;

	public LoginDto() {
	}

	public LoginDto(String userName, String password) {
		this.userName = userName;
		this.password = password;
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

	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {
		private String userName;
		private String password;

		public Builder userName(String userName) {
			this.userName = userName;
			return this;
		}

		public Builder password(String password) {
			this.password = password;
			return this;
		}

		public LoginDto build() {
			return new LoginDto(userName, password);
		}
	}

	@Override
	public String toString() {
		return "LoginDto{" + "userName='" + userName + '\'' + ", password='" + (password == null ? null : "***")
				+ '\'' + '}';
	}
}
