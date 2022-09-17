package com.harshit.Roommanagement.Model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="reservations")
public class Reservation {
@Id
private String reservationId;
private int numberOfRooms;
private int numberOfAdults;
private int numberOfChildren;
private Date checkIn;
private Date checkOut;
private String status;
private String roomId;
public String getReservationId() {
	return reservationId;
}
public void setReservationId(String reservationId) {
	this.reservationId = reservationId;
}
public int getNumberOfRooms() {
	return numberOfRooms;
}
public void setNumberOfRooms(int numberOfRooms) {
	this.numberOfRooms = numberOfRooms;
}
public int getNumberOfAdults() {
	return numberOfAdults;
}
public void setNumberOfAdults(int numberOfAdults) {
	this.numberOfAdults = numberOfAdults;
}
public int getNumberOfChildren() {
	return numberOfChildren;
}
public void setNumberOfChildren(int numberOfChildren) {
	this.numberOfChildren = numberOfChildren;
}
public Date getCheckIn() {
	return checkIn;
}
public void setCheckIn(Date checkIn) {
	this.checkIn = checkIn;
}
public Date getCheckOut() {
	return checkOut;
}
public void setCheckOut(Date checkOut) {
	this.checkOut = checkOut;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}

public String getRoomId() {
	return roomId;
}
public void setRoomType(String roomId) {
	this.roomId = roomId;
}


public Reservation(String reservationId, int numberOfRooms, int numberOfAdults, int numberOfChildren, Date checkIn,
		Date checkOut, String status, String roomId) {
	super();
	this.reservationId = reservationId;
	this.numberOfRooms = numberOfRooms;
	this.numberOfAdults = numberOfAdults;
	this.numberOfChildren = numberOfChildren;
	this.checkIn = checkIn;
	this.checkOut = checkOut;
	this.status = status;
	this.roomId = roomId;
}

public Reservation() {
	super();
	// TODO Auto-generated constructor stub
}


}
