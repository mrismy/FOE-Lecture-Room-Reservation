package com.rismy.FoE_RoomReservation.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "rooms")
public class Room {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long roomId;
	@Column(nullable = false)
	private int capacity;
	@Column(unique = true, nullable = false)
	private String roomName;
	private String description;
	private boolean isOnlyBookedByAdmin;

	@OneToMany(mappedBy = "room", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Booking> bookings = new ArrayList<Booking>();

	public Room() {
	}

	public Room(long roomId, int capacity, String roomName, String description, boolean isOnlyBookedByAdmin,
			List<Booking> bookings) {
		this.roomId = roomId;
		this.capacity = capacity;
		this.roomName = roomName;
		this.description = description;
		this.isOnlyBookedByAdmin = isOnlyBookedByAdmin;
		this.bookings = (bookings != null) ? bookings : new ArrayList<>();
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

	public boolean isOnlyBookedByAdmin() {
		return isOnlyBookedByAdmin;
	}

	public void setOnlyBookedByAdmin(boolean isOnlyBookedByAdmin) {
		this.isOnlyBookedByAdmin = isOnlyBookedByAdmin;
	}

	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = (bookings != null) ? bookings : new ArrayList<>();
	}

	@Override
	public String toString() {
		return "Room{" + "roomId=" + roomId + ", capacity=" + capacity + ", roomName='" + roomName + '\''
				+ ", description='" + description + '\'' + ", isOnlyBookedByAdmin=" + isOnlyBookedByAdmin + '}';
	}
}
