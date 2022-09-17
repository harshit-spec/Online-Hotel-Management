package com.harshit.UserManagement.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="guests")
public class Guest {
	@Id
	private String guestId;
	private String guestName;
	private String guestGender;
	private int guestAge;
	private String guestAddress;
	public String getGuestId() {
		return guestId;
	}
	public void setGuestId(String guestId) {
		this.guestId = guestId;
	}
	public String getGuestName() {
		return guestName;
	}
	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}
	public String getGuestGender() {
		return guestGender;
	}
	public void setGuestGender(String guestGender) {
		this.guestGender = guestGender;
	}
	public int getGuestAge() {
		return guestAge;
	}
	public void setGuestAge(int guestAge) {
		this.guestAge = guestAge;
	}
	public String getGuestAddress() {
		return guestAddress;
	}
	public void setGuestAddress(String guestAddress) {
		this.guestAddress = guestAddress;
	}
	public Guest(String guestId, String guestName, String guestGender, int guestAge, String guestAddress) {
		super();
		this.guestId = guestId;
		this.guestName = guestName;
		this.guestGender = guestGender;
		this.guestAge = guestAge;
		this.guestAddress = guestAddress;
	}
	public Guest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
