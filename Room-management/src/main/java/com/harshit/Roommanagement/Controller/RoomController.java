package com.harshit.Roommanagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.harshit.Roommanagement.Model.Registration;
import com.harshit.Roommanagement.Model.Reservation;
import com.harshit.Roommanagement.Model.Room;
import com.harshit.Roommanagement.Service.RoomService;

@RestController

public class RoomController {
@Autowired
private RoomService roomService;
	
@PostMapping("addRoom")
public Room addRoom(@RequestBody Room room) {
	return roomService.addRooms(room);
	}
@GetMapping("viewRoom/{roomId}")
public Room viewRoom(@PathVariable String roomId) {
	return roomService.getRoom(roomId);
}
@GetMapping("viewAllRooms")
public List<Room> viewAllRooms(){
	return roomService.getAllRooms();
}
@DeleteMapping("removeRoom/{roomId}")
public void deleteRoom(@PathVariable String roomId) {
	roomService.removeRoom(roomId);
}
@PutMapping("updateRoom")
	public Room updateRoom(@RequestBody Room room) throws Exception {
		return roomService.updateRoom(room);
	}
 @PostMapping("/addbooking")
 public Reservation addReservation(@RequestBody Reservation reservation) {
	 return roomService.saveReservation(reservation);
 }
 @GetMapping("/viewbooking/{reservationId}")
 public Reservation viewReservation(@PathVariable String reservationId) {
 	return roomService.getReservation(reservationId);
 }
 @GetMapping("viewAllbookings")
 public List<Reservation> viewAllRerservations(){
 	return roomService.getAllbookings();
 }
 @PutMapping("updatebooking/{reservationId}")
	public Reservation updateReservation(@RequestBody Reservation reservation) throws Exception {
		return roomService.updateReservation(reservation);
	}
 @DeleteMapping("deletebooking/{reservationId}")
 public void deleteReservation(@PathVariable String reservationId) {
	 roomService.removeReservation(reservationId);
 }
 @GetMapping("/reservation/{reservationId}")
 public Registration getReserved(@PathVariable String reservationId) {
	 return roomService.getReservationdetails(reservationId);
 }












}
