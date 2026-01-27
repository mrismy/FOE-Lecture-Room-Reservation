package com.rismy.FoE_RoomReservation.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "events")
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long eventId;

	@OneToMany(mappedBy = "event", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Booking> bookings = new ArrayList<Booking>();

	public Event() {
	}

	public Event(long eventId, List<Booking> bookings) {
		this.eventId = eventId;
		this.bookings = (bookings != null) ? bookings : new ArrayList<>();
	}

	public long getEventId() {
		return eventId;
	}

	public void setEventId(long eventId) {
		this.eventId = eventId;
	}

	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = (bookings != null) ? bookings : new ArrayList<>();
	}

	@Override
	public String toString() {
		return "Event{" + "eventId=" + eventId + '}';
	}
}
