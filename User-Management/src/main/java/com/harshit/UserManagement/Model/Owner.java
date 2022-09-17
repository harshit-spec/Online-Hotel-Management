package com.harshit.UserManagement.Model;

import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="owner")
public class Owner   {

private String ownerId;
private String userName;
private String role;
private String password;
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getOwnerId() {
	return ownerId;
}
public void setOwnerId(String ownerId) {
	this.ownerId = ownerId;
}
public String getUserName() {
	return userName;
}
public void setUserName(String username) {
	this.userName = username;
}

public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
public Owner(String ownerId, String userName, String role,String password) {
	super();
	this.ownerId = ownerId;
	this.userName = userName;
	this.role = role;
	this.password=password;
}
public Owner() {
	super();
	// TODO Auto-generated constructor stub
}
 



}
