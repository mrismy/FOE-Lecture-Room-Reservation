package com.rismy.FoE_RoomReservation.dto;

public class LoginResponseDto {

	private String token;

	public LoginResponseDto() {
	}

	public LoginResponseDto(String token) {
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {
		private String token;

		public Builder token(String token) {
			this.token = token;
			return this;
		}

		public LoginResponseDto build() {
			return new LoginResponseDto(token);
		}
	}

	@Override
	public String toString() {
		return "LoginResponseDto{" + "token='" + (token == null ? null : "***") + '\'' + '}';
	}
}
