package com.harshit.UserManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.harshit.UserManagement.Model.Guest;
import com.harshit.UserManagement.Model.Inventory;
import com.harshit.UserManagement.Model.Manager;
import com.harshit.UserManagement.Model.Owner;
import com.harshit.UserManagement.Model.Receptionist;
import com.harshit.UserManagement.Model.Reservation;
import com.harshit.UserManagement.Model.Room;
import com.harshit.UserManagement.Model.Users;
import com.harshit.UserManagement.Service.UserService;

@RestController
public class UserController {
@Autowired
private UserService userService;

@Autowired
private RestTemplate restTemplate;
@PostMapping("/Owner/add")
public Owner addOwner(@RequestBody Owner owner) {
	return userService.addOwner(owner);
}
@GetMapping("viewOwner/{ownerId}")
public Owner viewOwner(@PathVariable String ownerId) {
	return userService.getOwner(ownerId);
}

@PostMapping("addManager")
public Manager addManager(@RequestBody Manager manager) {
	return userService.saveManager(manager);
	}
//@PreAuthorize("hasAuthority('Owner')")
@GetMapping("viewManager/{managerId}")
public Manager viewManager(@PathVariable String managerId) {
	return userService.getManager(managerId);
}
@GetMapping("viewAllManagers")
public List<Manager> viewAllManagers(){
	return userService.getAllManagers();
}
@DeleteMapping("removeManager/{managerId}")
public void deleteManager(@PathVariable String managerId) {
	userService.removeManager(managerId);
}
@PutMapping("updateManager")
	public Manager updateManager(@RequestBody Manager manager) throws Exception {
		return userService.updateManagerDetails(manager);
	}

@PostMapping("addGuest")
public Guest addGuest(@RequestBody Guest guest) {
	return userService.saveGuest(guest);
	}
@GetMapping("viewGuest/{guestId}")
public Guest viewGuest(@PathVariable String guestId) {
	return userService.getGuest(guestId);
}
@GetMapping("viewAllGuests")
public List<Guest> viewAllGuests(){
	return userService.getAllGuests();
}
@DeleteMapping("removeGuest/{guestId}")
public void deleteGuest(@PathVariable String guestId) {
	userService.removeGuest(guestId);
}
@PutMapping("updateGuest")
	public Guest updateGuest(@RequestBody Guest guest) throws Exception {
		return userService.updateGuestDetails(guest);
	}
@PostMapping("addReceptionist")
public Receptionist addReceptionist(@RequestBody Receptionist receptionist) {
	return userService.saveReceptionist(receptionist);
	}
@GetMapping("viewReceptionist/{receptionistId}")
public Receptionist viewReceptionist(@PathVariable String receptionistId) {
	return userService.getReceptionist(receptionistId);
}
@GetMapping("viewAllReceptionists")
public List<Receptionist> viewAllReceptionists(){
	return userService.getAllReceptionists();
}
@DeleteMapping("removeReceptionist/{receptionistId}")
public void deleteReceptionist(@PathVariable String receptionistId) {
	userService.removeReceptionist(receptionistId);
}
@PutMapping("updateReceptionist")
	public Receptionist updateReceptionist(@RequestBody Receptionist receptionist) throws Exception {
		return userService.updateReceptionistDetails(receptionist);
	}
@PostMapping("addRoom")
public Room addRooms(@RequestBody Room room) {
	return restTemplate.postForObject("http://localhost:8082/addRoom", room, Room.class);
}
@GetMapping("viewRoom/{roomId}")
public Room viewRoom(@PathVariable String roomId) {
	return restTemplate.getForObject("http://8082/viewRoom"+roomId, Room.class);
}
@SuppressWarnings("unchecked")
@GetMapping("viewAllRooms")
public List<Room> viewAllRooms(){
	return restTemplate.getForObject("http://localhost:8082/viewAllRooms", List.class);
}
@DeleteMapping("removeRoom/{roomId}")
public void deleteRoom(@PathVariable String roomId) {
	restTemplate.delete("http://localhost:8082/removeRoom"+roomId,Room.class);
}
@PutMapping("updateRoom")
	public String updateRoom(@RequestBody Room room) throws Exception {
	restTemplate.put("http://localhost:8082/updateRoom", Room.class);
	return "Updated Succesfully";
	}
@PostMapping("addInventory")
public Inventory addInventory(@RequestBody Inventory inventory) {
	return restTemplate.postForObject("http://localhost:8081/inventory/add", inventory, Inventory.class);
}
@GetMapping("viewInventory/{inId}")
public Inventory getInventory(@PathVariable String inId) {
	return restTemplate.getForObject("http://localhost:8081/inventory/"+inId,Inventory.class);
}
@SuppressWarnings("unchecked")
@GetMapping("viewAllItems")
public List<Inventory> getAllItems(){
	return restTemplate.getForObject("http://localhost:8081/inventory/list", List.class);
}
@DeleteMapping("deleteItem/{inId}")
public String deleteItem(@PathVariable String inId) {
	restTemplate.delete("http://localhost:8081/inventory/"+inId, Inventory.class);
	return "deleted succesfully";
}
@PutMapping("/updateItem/{inId}")
public String updateItem(@PathVariable String inId) {
	restTemplate.put("localhost:8081/inventory/update", Inventory.class);
	return "updated successfully";
}
@PostMapping("/addReservation")
public Reservation addreservation(@RequestBody Reservation reservation) {
	return restTemplate.postForObject("http://localhost:8082/addbooking", reservation, Reservation.class);
}
@GetMapping("/viewReservation/{reservationId}")
public Reservation getreservation(@PathVariable String reservationId) {
	return restTemplate.getForObject("http://localhost:8082/viewbooking/"+reservationId,Reservation.class);
}
@SuppressWarnings("unchecked")
@GetMapping("/viewAllreservations")
public List<Reservation> getAllreservation(){
	return restTemplate.getForObject("http://localhost:8082/viewAllbookings", List.class);
}
@DeleteMapping("deleteReservation/{reservationId}")
public String deletereservation(@PathVariable String reservationId) {
	restTemplate.delete("http://localhost:8082/deletebooking"+reservationId, Reservation.class);
	return "deleted succesfully";
}
@PutMapping("updatereservation/{reservationId}")
public String updateReservation(@PathVariable String reservationId) {
	restTemplate.put("http://localhost:8082/updatebooking"+reservationId, Reservation.class);
	return "updated Succesfully";
}
@GetMapping("viewAllUsers")
public List<Users> getUsers(){
	return userService.getAllUsers();
}




}
