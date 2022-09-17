package com.harshit.Roommanagement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;


import com.harshit.Roommanagement.Model.Reservation;
import com.harshit.Roommanagement.Model.Room;
import com.harshit.Roommanagement.Repo.ReservationRepository;
import com.harshit.Roommanagement.Repo.RoomRepository;
import com.harshit.Roommanagement.Service.RoomService;

@SpringBootTest
class RoomManagementApplicationTests {
	@MockBean
	private RoomRepository roomRepository;
	@MockBean
	private ReservationRepository reservationRepository;
		@Autowired
	private RoomService roomService;
		
	@Test
	public void getroomsTest() {
		when(roomRepository.findAll()).thenReturn(Stream.of(new Room("1","suite",5000,"booked"),
				new Room("2","presedential",50000,"not booked")).collect(Collectors.toList()));
		assertEquals(2, roomService.getAllRooms().size());
	}
	@Test
	public void getroomsTest_1() {
		when(roomRepository.findAll()).thenReturn(Stream.of(new Room("1","suite",5000,"booked"),
				new Room("2","presedential",50000,"not booked")).collect(Collectors.toList()));
		assertEquals(4, roomService.getAllRooms().size());
	}
	@Test
	public void getrerservationsTest() {
		when(reservationRepository.findAll()).thenReturn(Stream.of(new Reservation("1",1,2,0,new java.util.Date(System.currentTimeMillis()),new java.util.Date(System.currentTimeMillis()),"booked","10"),
				new Reservation("2",2,2,2,new java.util.Date(System.currentTimeMillis()),new java.util.Date(System.currentTimeMillis()),"booked","11")).collect(Collectors.toList()));
		assertEquals(2, roomService.getAllbookings().size());
	}
	@Test
	public void getrerservationsTest_1() {
		when(reservationRepository.findAll()).thenReturn(Stream.of(new Reservation("1",1,2,0,new java.util.Date(System.currentTimeMillis()),new java.util.Date(System.currentTimeMillis()),"booked","10"),
				new Reservation("2",2,2,2,new java.util.Date(System.currentTimeMillis()),new java.util.Date(System.currentTimeMillis()),"booked","11")).collect(Collectors.toList()));
		assertEquals(5, roomService.getAllbookings().size());
	}
	@Test
	public void saveRoom() {
		Room room = new Room("2","presedential",50000,"not booked");
		when(roomRepository.save(room)).thenReturn(room);
		assertEquals(room,roomService.addRooms(room));
	}
	@Test
	public void saveRoom_1() {
		Room room = new Room("2","presedential",50000,"not booked");
		Room rom = new Room("3","suite",5000,"booked");
		when(roomRepository.save(room)).thenReturn(room);
		assertEquals(rom,roomService.addRooms(room));
	}
	@Test
	public void saveReservation() {
		Reservation reserve = new Reservation("1",1,2,0,new java.util.Date(System.currentTimeMillis()),new java.util.Date(System.currentTimeMillis()),"booked","10");
		when(reservationRepository.save(reserve)).thenReturn(reserve);
		assertEquals(reserve,roomService.saveReservation(reserve));
	}
	@Test
	public void saveReservation_1() {
		Reservation reserve = new Reservation("1",1,2,0,new java.util.Date(System.currentTimeMillis()),new java.util.Date(System.currentTimeMillis()),"booked","10");
		Reservation reserved = new Reservation("2",1,3,1,new java.util.Date(System.currentTimeMillis()),new java.util.Date(System.currentTimeMillis()),"not booked","11");
		when(reservationRepository.save(reserve)).thenReturn(reserve);
		assertEquals(reserved,roomService.saveReservation(reserve));
	}
	@Test
	public void deleteRoom() {
		Room room = new Room("1","suite",5000,"booked");
		roomService.removeRoom("1");
		verify(roomRepository,times(1)).deleteById("1");
	}
	@Test
	public void deleteReservation() {
		Reservation reserve = new Reservation("2",2,2,2,new java.util.Date(System.currentTimeMillis()),new java.util.Date(System.currentTimeMillis()),"booked","11");
		roomService.removeReservation("2");
		verify(reservationRepository,times(1)).deleteById("2");
	}
	@Test
	public void updateRoom() throws NotFoundException {
		Room room = new Room("1","suite",5000,"booked");
		String id = room.getRoomId();
		room.setRoomPrice(500);
		roomRepository.save(room);
		when(roomRepository.findById(id)).thenReturn(Optional.of(room));
		assertEquals(room,roomService.updateRoom(room));
	}
	@Test
	public void updateReservation() throws NotFoundException {
		Reservation reservation = new Reservation("2",2,2,2,new java.util.Date(System.currentTimeMillis()),new java.util.Date(System.currentTimeMillis()),"booked","11");
		String id = reservation.getReservationId();
		reservation.setNumberOfAdults(3);
		reservationRepository.save(reservation);
		when(reservationRepository.findById(id)).thenReturn(Optional.of(reservation));
		assertEquals(reservation,roomService.updateReservation(reservation));
	}
	
	@Test
	public void getRoomTest() {
		Room room = new Room("1","suite",5000,"booked");

		when(roomRepository.findById(anyString())).thenReturn(Optional.of(room));
		assertEquals(room,roomService.getRoom("id"));
	}
	
	@Test
	public void getreservationTest() {
		Reservation reservation = new Reservation("2",2,2,2,new java.util.Date(System.currentTimeMillis()),new java.util.Date(System.currentTimeMillis()),"booked","11");

		when(reservationRepository.findById(anyString())).thenReturn(Optional.of(reservation));
		assertEquals(reservation,roomService.getReservation("id"));
	}
}
