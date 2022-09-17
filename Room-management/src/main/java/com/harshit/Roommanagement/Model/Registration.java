package com.harshit.Roommanagement.Model;

public class Registration {
private Room room;
private Reservation resevation;
public Room getRoom() {
	return room;
}
public void setRoom(Room room) {
	this.room = room;
}
public Reservation getResevation() {
	return resevation;
}
public void setResevation(Reservation resevation) {
	this.resevation = resevation;
}
public Registration(Room room, Reservation resevation) {
	super();
	this.room = room;
	this.resevation = resevation;
}
public Registration() {
	super();
	// TODO Auto-generated constructor stub
}


}
