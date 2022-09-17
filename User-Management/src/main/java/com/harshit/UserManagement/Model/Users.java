package com.harshit.UserManagement.Model;



import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="users")
public class Users {
	@Autowired
	private Owner owner;
	@Autowired
	private Manager manager;
	@Autowired
	private Receptionist receptionist;
private List<String> password;
private List<String> username;
private List<String> role;
public List<String> getPassword() {
	return password;
}
public void setPassword(List<String> password) {
	this.password = Arrays.asList(owner.getPassword(),manager.getPassword(),receptionist.getPassword());
}
public List<String> getUsername() {
	return username;
}
public void setUsername(List<String> username) {
	this.username = Arrays.asList(owner.getUserName(),manager.getUsername(),receptionist.getUsername());
}
public List<String> getRole() {
	return role;
}
public void setRole(List<String> role) {
	this.role = Arrays.asList(owner.getRole(),manager.getRole(),receptionist.getRole());
}
public Users() {
	super();
	// TODO Auto-generated constructor stub
}
public Users(List<String> password, List<String> username, List<String> role) {
	super();
	this.password = password;
	this.username = username;
	this.role = role;
}


}