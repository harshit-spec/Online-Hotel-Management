package com.harshit.UserManagement.Model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="receptionists")
public class Receptionist {

	private String recId;
	private String username;
    private String password;
    private String role;
    
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getRecId() {
		return recId;
	}
	public void setRecId(String recId) {
		this.recId = recId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Receptionist(String recId, String username, String password,String role) {
		super();
		this.recId = recId;
		this.username = username;
		this.password = password;
		this.role = role;
	}
	public Receptionist() {
		super();
		// TODO Auto-generated constructor stub
	}	
	

}
