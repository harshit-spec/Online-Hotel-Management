package com.harshit.UserManagement.Model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="managers")
public class Manager {

private String managerId;
private String username;
private String role;
private String password;
public String getManagerId() {
	return managerId;
}
public void setManagerId(String managerId) {
	this.managerId = managerId;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}

public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public Manager(String managerId, String username, String role, String password) {
	super();
	this.managerId = managerId;
	this.username = username;
	this.role = role;
	this.password = password;
}
public Manager() {
	super();
	// TODO Auto-generated constructor stub
}



}
