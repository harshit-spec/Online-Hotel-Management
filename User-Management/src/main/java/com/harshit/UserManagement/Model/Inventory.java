package com.harshit.UserManagement.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="inventories")
public class Inventory {
@Id
private String inId;
private String InName;
private int quantity;
private int price;
public String getInId() {
	return inId;
}
public void setInId(String inId) {
	this.inId = inId;
}
public String getInName() {
	return InName;
}
public void setInName(String inName) {
	InName = inName;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public Inventory(String inId, String inName, int quantity, int price) {
	super();
	this.inId = inId;
	InName = inName;
	this.quantity = quantity;
	this.price = price;
}
public Inventory() {
	
}

}
