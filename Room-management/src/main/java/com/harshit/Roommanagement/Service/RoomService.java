package com.harshit.Roommanagement.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.harshit.Roommanagement.Model.Registration;
import com.harshit.Roommanagement.Model.Reservation;
import com.harshit.Roommanagement.Model.Room;
import com.harshit.Roommanagement.Repo.ReservationRepository;
import com.harshit.Roommanagement.Repo.RoomRepository;

@Service
public class RoomService {
@Autowired
private RoomRepository roomRepository;
@Autowired
private ReservationRepository reservationRepository;

public  Room addRooms(Room room) {
	return roomRepository.save(room);
}

public Room getRoom(String roomId) {
	
	return roomRepository.findById(roomId).get();
}

public List<Room> getAllRooms() {
	
	return roomRepository.findAll();
}

public void removeRoom(String roomId) {
	
	 roomRepository.deleteById(roomId);
}

public Room updateRoom(Room room) throws NotFoundException{
	
	Optional<Room> opRoom =roomRepository.findById(room.getRoomId());
	if(!opRoom.isPresent()) {
		throw new NotFoundException();
	}
	Room rom= opRoom.get();
	rom.setStatus(room.getStatus());
	rom.setRoomPrice(room.getRoomPrice());
	rom.setRoomType(room.getRoomType());
	
	return roomRepository.save(rom);
}

public Reservation saveReservation(Reservation reservation) {
	
	return reservationRepository.save(reservation);
}

public Reservation getReservation(String reservationId) {
	return reservationRepository.findById(reservationId).get();
}

public List<Reservation> getAllbookings() {
	
	return reservationRepository.findAll();
}

public Reservation updateReservation(Reservation reservation) throws NotFoundException {
	
	 Optional<Reservation> opReserve =reservationRepository.findById(reservation.getReservationId());
	if(!opReserve.isPresent()) {
		throw new NotFoundException();
	}
	Reservation res= opReserve.get();
	res.setStatus(reservation.getStatus());
	res.setNumberOfAdults(reservation.getNumberOfAdults());
	res.setNumberOfChildren(reservation.getNumberOfChildren());
	res.setCheckIn(reservation.getCheckIn());
	res.setCheckOut(reservation.getCheckOut());
	res.setNumberOfRooms(reservation.getNumberOfRooms());
	
	
	return reservationRepository.save(res);
}

public void removeReservation(String reservationId) {
	reservationRepository.deleteById(reservationId);
	
}

public Registration getReservationdetails(String reservationId) {
	Registration register = new Registration();
	Reservation reserve = new Reservation();
	String id = reserve.getRoomId();
	Room rom = roomRepository.findById(id).get();
	Reservation reservation = reservationRepository.findById(reservationId).get();
	register.setResevation(reservation);
	register.setRoom(rom);
return register;	
} 
}







