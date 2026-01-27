package com.rismy.FoE_RoomReservation.model;

import java.sql.Date;
import java.sql.Time;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "bookings")
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long bookingId;
	private Time startTime;
	private Time endTime;
	private Date date;
	private Date startDate;
	private Date endDate;
	@Enumerated(EnumType.STRING)
	private RecurrenceType recurrence;
	private int recurrencePeriod;
	private String details;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "eventId")
	private Event event;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "roomId")
	private Room room;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UserId")
	private User user;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "bookedFor")
	private User bookedForUser;

	public enum RecurrenceType {
		none, daily, weekly
	};

	public Booking() {
	}

	public Booking(long bookingId, Time startTime, Time endTime, Date date, Date startDate, Date endDate,
			RecurrenceType recurrence, int recurrencePeriod, String details, Event event, Room room, User user,
			User bookedForUser) {
		this.bookingId = bookingId;
		this.startTime = startTime;
		this.endTime = endTime;
		this.date = date;
		this.startDate = startDate;
		this.endDate = endDate;
		this.recurrence = recurrence;
		this.recurrencePeriod = recurrencePeriod;
		this.details = details;
		this.event = event;
		this.room = room;
		this.user = user;
		this.bookedForUser = bookedForUser;
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

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getBookedForUser() {
		return bookedForUser;
	}

	public void setBookedForUser(User bookedForUser) {
		this.bookedForUser = bookedForUser;
	}

	@Override
	public String toString() {
		return "Booking{" + "bookingId=" + bookingId + ", startTime=" + startTime + ", endTime=" + endTime
				+ ", date=" + date + ", startDate=" + startDate + ", endDate=" + endDate + ", recurrence=" + recurrence
				+ ", recurrencePeriod=" + recurrencePeriod + ", details='" + details + '\'' + '}';
	}
}
