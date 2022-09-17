package com.harshit.Inventoryservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import com.harshit.Inventoryservice.model.Inventory;

public interface InventoryService  {
	public Inventory addinventory(Inventory inventory);

	public List<Inventory> getAllInventories();

	public Inventory getInventory(String inId); 

	public void deleteInventory(String inId); 

	public Optional<Inventory> updateInventory(Inventory inventory,String inId) ;
}
