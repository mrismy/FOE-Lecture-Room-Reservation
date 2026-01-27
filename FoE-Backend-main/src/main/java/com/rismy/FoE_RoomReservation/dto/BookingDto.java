package com.rismy.FoE_RoomReservation.dto;

import java.sql.Date;
import java.sql.Time;

import com.rismy.FoE_RoomReservation.model.Booking.RecurrenceType;

public class BookingDto {

	private long bookingId;
	private Time startTime;
	private Time endTime;
	private Date date;
	private Date startDate;
	private Date endDate;
	private RecurrenceType recurrence;
	private int recurrencePeriod;
	private String details;
	private UserDto user;
	private RoomDto room;

	public BookingDto() {
	}

	public BookingDto(long bookingId, Time startTime, Time endTime, Date date, Date startDate, Date endDate,
			RecurrenceType recurrence, int recurrencePeriod, String details, UserDto user, RoomDto room) {
		this.bookingId = bookingId;
		this.startTime = startTime;
		this.endTime = endTime;
		this.date = date;
		this.startDate = startDate;
		this.endDate = endDate;
		this.recurrence = recurrence;
		this.recurrencePeriod = recurrencePeriod;
		this.details = details;
		this.user = user;
		this.room = room;
	}

	public long getBookingId() {
		return bookingId;
	}

	public void setBookingId(long bookingId) {
		this.bookingId = bookingId;
	}

	public Time getStartTime() {
		return startTime;
	}

	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}

	public Time getEndTime() {
		return endTime;
	}

	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public RecurrenceType getRecurrence() {
		return recurrence;
	}

	public void setRecurrence(RecurrenceType recurrence) {
		this.recurrence = recurrence;
	}

	public int getRecurrencePeriod() {
		return recurrencePeriod;
	}

	public void setRecurrencePeriod(int recurrencePeriod) {
		this.recurrencePeriod = recurrencePeriod;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
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

	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {
		private long bookingId;
		private Time startTime;
		private Time endTime;
		private Date date;
		private Date startDate;
		private Date endDate;
		private RecurrenceType recurrence;
		private int recurrencePeriod;
		private String details;
		private UserDto user;
		private RoomDto room;

		public Builder bookingId(long bookingId) {
			this.bookingId = bookingId;
			return this;
		}

		public Builder startTime(Time startTime) {
			this.startTime = startTime;
			return this;
		}

		public Builder endTime(Time endTime) {
			this.endTime = endTime;
			return this;
		}

		public Builder date(Date date) {
			this.date = date;
			return this;
		}

		public Builder startDate(Date startDate) {
			this.startDate = startDate;
			return this;
		}

		public Builder endDate(Date endDate) {
			this.endDate = endDate;
			return this;
		}

		public Builder recurrence(RecurrenceType recurrence) {
			this.recurrence = recurrence;
			return this;
		}

		public Builder recurrencePeriod(int recurrencePeriod) {
			this.recurrencePeriod = recurrencePeriod;
			return this;
		}

		public Builder details(String details) {
			this.details = details;
			return this;
		}

		public Builder user(UserDto user) {
			this.user = user;
			return this;
		}

		public Builder room(RoomDto room) {
			this.room = room;
			return this;
		}

		public BookingDto build() {
			return new BookingDto(bookingId, startTime, endTime, date, startDate, endDate, recurrence, recurrencePeriod,
				details, user, room);
		}
	}

	@Override
	public String toString() {
		return "BookingDto{" + "bookingId=" + bookingId + ", startTime=" + startTime + ", endTime=" + endTime
				+ ", date=" + date + ", startDate=" + startDate + ", endDate=" + endDate + ", recurrence=" + recurrence
				+ ", recurrencePeriod=" + recurrencePeriod + ", details='" + details + '\'' + ", user=" + user
				+ ", room=" + room + '}';
	}
}
