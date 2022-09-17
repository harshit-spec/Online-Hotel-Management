package com.harshit.UserManagement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.harshit.UserManagement.Model.Guest;
import com.harshit.UserManagement.Model.Manager;
import com.harshit.UserManagement.Model.Receptionist;
import com.harshit.UserManagement.Repository.GuestRepository;
import com.harshit.UserManagement.Repository.ManagerRepository;
import com.harshit.UserManagement.Repository.ReceptionistRepository;
import com.harshit.UserManagement.Service.UserService;

@SpringBootTest
@RunWith(SpringRunner.class)
class UserManagementApplicationTests {

	@Autowired
	private UserService userService;
	
	@MockBean
	private ManagerRepository managerRepository;
	
	@MockBean
	private ReceptionistRepository receptionistRepository;
	
	@MockBean
	private GuestRepository guestRepository;
	
	
	@Test
	public void getManagersTest() {
		when(managerRepository.findAll()).thenReturn(Stream.of(new Manager("m1","suresh","suresh@123","Manager"),
				new Manager("m2","ramesh","ramesh@123","Manager")).collect(Collectors.toList()));
		assertEquals(2, userService.getAllManagers().size());
	}
@Test
public void getManagersTest_1() {
	when(managerRepository.findAll()).thenReturn(Stream.of(new Manager("m1","suresh","suresh@123","Manager"),
			new Manager("m2","ramesh","ramesh@123","Manager")).collect(Collectors.toList()));
	assertEquals(3, userService.getAllManagers().size());
}
@Test
public void saveManagerTest() {
	Manager manager = new Manager("m1","suresh","123","Manager");
	when(managerRepository.save(manager)).thenReturn(manager);
	assertEquals(manager,userService.saveManager(manager));
}
@Test
public void saveManagerTest_1() {
	Manager manager = new Manager("m1","suresh","123","Manager");
	Manager manager_1 = new Manager("m2","Ramesh","123","Manager");
	when(managerRepository.save(manager)).thenReturn(manager);
	assertEquals(manager_1,userService.saveManager(manager));
}
@SuppressWarnings("unused")
@Test
public void deleteTest() {
	Manager manager = new Manager("m1","suresh","123","Manager");
	userService.removeManager("m1");
	verify(managerRepository,times(1)).deleteById("m1");
}
@SuppressWarnings("unused")
@Test
public void deleteTest_1() {
	Manager manager = new Manager("m1","suresh","123","Manager");
	Manager manager_1 = new Manager("m2","Ramesh","123","Manager");
	userService.removeManager("m1");
	verify(managerRepository,times(2)).deleteById("m2");
}
@Test
public void getreceptionistTest() {
	when(receptionistRepository.findAll()).thenReturn(Stream.of(new Receptionist("r1","jimmy","jimmy@123","Receptionist"),
			new Receptionist("r2","ramya","ramya@123","Receptionist")).collect(Collectors.toList()));
	assertEquals(2, userService.getAllReceptionists().size());
}
@Test
public void getreceptionistTest_1() {
	when(receptionistRepository.findAll()).thenReturn(Stream.of(new Receptionist("r1","jimmy","jimmy@123","Receptionist"),
			new Receptionist("r2","ramya","ramya@123","Receptionist")).collect(Collectors.toList()));
	assertEquals(3, userService.getAllReceptionists().size());
}
@Test
public void savereceptionistTest() {
	Receptionist reception = new Receptionist("r1","jimmy","123","Receptionist");
	when(receptionistRepository.save(reception)).thenReturn(reception);
	assertEquals(reception,userService.saveReceptionist(reception));
}
@Test
public void saveReceptionistTest_1() {
	Receptionist reception = new Receptionist("r1","jimmy","123","Receptionist");
	Receptionist receptionist = new Receptionist("r2","jammy","123","Receptionist");
	when(receptionistRepository.save(reception)).thenReturn(reception);
	assertEquals(receptionist,userService.saveReceptionist(reception));
}
@SuppressWarnings("unused")
@Test
public void deleteReceptionistTest() {
	Receptionist receptionist = new Receptionist("r2","jammy","123","Receptionist");
	userService.removeReceptionist("r2");
	verify(receptionistRepository,times(1)).deleteById("r2");
}
@SuppressWarnings("unused")
@Test
public void deletereceptionistTest_1() {
	Receptionist reception = new Receptionist("r1","jimmy","123","Receptionist");
	Receptionist receptionist = new Receptionist("r2","jammy","123","Receptionist");
	userService.removeReceptionist("r2");
	verify(managerRepository,times(2)).deleteById("r1");
}
@Test
public void getGuestsTest() {
	when(guestRepository.findAll()).thenReturn(Stream.of(new Guest("g1","suresh","Male",30,"america"),
			new Guest("g2","ramesh","Male",25,"america")).collect(Collectors.toList()));
	assertEquals(2, userService.getAllGuests().size());
}
@Test
public void getGuestsTest_1() {
when(guestRepository.findAll()).thenReturn(Stream.of(new Guest("g1","suresh","Male",30,"america"),
		new Guest("g2","ramesh","Male",25,"america")).collect(Collectors.toList()));
assertEquals(3, userService.getAllGuests().size());
}
@Test
public void saveGuestTest() {
Guest guest  = new Guest("g1","suresh","Male",30,"america");
when(guestRepository.save(guest)).thenReturn(guest);
assertEquals(guest,userService.saveGuest(guest));
}
@Test
public void saveGuestTest_1() {
Guest guest = new Guest("g2","ramesh","Male",25,"america");
Guest guest_1 = new Guest("g1","suresh","Male",30,"america");
when(guestRepository.save(guest)).thenReturn(guest);
assertEquals(guest_1,userService.saveGuest(guest));
}
@Test
public void deleteGuestTest() {
@SuppressWarnings("unused")
Guest guest = new Guest("g1","suresh","Male",30,"america");
userService.removeGuest("g1");
verify(guestRepository,times(1)).deleteById("g1");
}
@SuppressWarnings("unused")
@Test
public void deleteGuestTest_1() {
	Guest guest = new Guest("g2","ramesh","Male",25,"america");
	Guest guest_1 = new Guest("g1","suresh","Male",30,"america");
userService.removeManager("g1");
verify(managerRepository,times(2)).deleteById("g2");
}

}
