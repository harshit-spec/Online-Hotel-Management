package com.harshit.Roommanagement.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="rooms")
public class Room {
@Id
private String roomId;
private String roomType;
private int roomPrice;
private String status;
public String getRoomId() {
	return roomId;
}
public void setRoomId(String roomId) {
	this.roomId = roomId;
}
public String getRoomType() {
	return roomType;
}
public void setRoomType(String roomType) {
	this.roomType = roomType;
}
public int getRoomPrice() {
	return roomPrice;
}
public void setRoomPrice(int roomPrice) {
	this.roomPrice = roomPrice;
}
public String getStatus(){
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public Room(String roomId, String roomType, int roomPrice, String status) {
	super();
	this.roomId = roomId;
	this.roomType = roomType;
	this.roomPrice = roomPrice;
	this.status = status;
}
public Room() {
	super();
	// TODO Auto-generated constructor stub
}

}
