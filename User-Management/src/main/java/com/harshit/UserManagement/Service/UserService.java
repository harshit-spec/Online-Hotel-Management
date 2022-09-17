package com.harshit.UserManagement.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.harshit.UserManagement.Model.Guest;
import com.harshit.UserManagement.Model.Manager;
import com.harshit.UserManagement.Model.Owner;
import com.harshit.UserManagement.Model.Receptionist;
import com.harshit.UserManagement.Model.Users;
import com.harshit.UserManagement.Repository.GuestRepository;
import com.harshit.UserManagement.Repository.ManagerRepository;
import com.harshit.UserManagement.Repository.OwnerRepository;
import com.harshit.UserManagement.Repository.ReceptionistRepository;
import com.harshit.UserManagement.Repository.UserRepository;


@Service
public class UserService {

@Autowired
private ManagerRepository managerRepository;

@Autowired
private ReceptionistRepository receptionistRepository;

@Autowired
private GuestRepository guestRepository;

@Autowired
private OwnerRepository ownerRepository;

@Autowired
private UserRepository userRepository;


public Manager saveManager(Manager manager) {
	
	return managerRepository.save(manager);
}
public Manager getManager(String managerId) {
	// TODO Auto-generated method stub
	
	return managerRepository.findById(managerId).get();
}
public List<Manager> getAllManagers() {
	// TODO Auto-generated method stub
	return managerRepository.findAll();
}
public void removeManager(String managerId) {
	// TODO Auto-generated method stub
	managerRepository.deleteById(managerId);
	
}
public Manager updateManagerDetails(Manager manager) {
	// TODO Auto-generated method stub
	return null;
}
public Receptionist saveReceptionist(Receptionist receptionist) {
	// TODO Auto-generated method stub
	return receptionistRepository.save(receptionist) ;
}
public Receptionist getReceptionist(String receptionistId) {
	// TODO Auto-generated method stub
	return receptionistRepository.findById(receptionistId).get();
}
public List<Receptionist> getAllReceptionists() {
	// TODO Auto-generated method stub
	return receptionistRepository.findAll();
}
public void removeReceptionist(String receptionistId) {
	// TODO Auto-generated method stub
	receptionistRepository.deleteById(receptionistId);
	
}
public Receptionist updateReceptionistDetails(Receptionist receptionist) {
	// TODO Auto-generated method stub
	return null;
}
public Guest saveGuest(Guest guest) {
	// TODO Auto-generated method stub
	return guestRepository.save(guest);
}
public Guest getGuest(String guestId) {
	// TODO Auto-generated method stub
	return guestRepository.findById(guestId).get();
}
public List<Guest> getAllGuests() {
	// TODO Auto-generated method stub
	return guestRepository.findAll();
}
public void removeGuest(String guestId) {
	// TODO Auto-generated method stub
	guestRepository.deleteById(guestId);
}
public Guest updateGuestDetails(Guest guest) {
	// TODO Auto-generated method stub
	return null;
}
public Owner addOwner(Owner owner) {
	// TODO Auto-generated method stub
	return ownerRepository.save(owner);
}
public Owner getOwner(String ownerId) {// TODO Auto-generated method stub
	return ownerRepository.findById(ownerId).get();
}
public List<Users> getAllUsers() {
	
	return userRepository.findAll();
}


}
