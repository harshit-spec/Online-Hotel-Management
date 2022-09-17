package com.harshit.Inventoryservice.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;


import com.harshit.Inventoryservice.model.Inventory;
import com.harshit.Inventoryservice.repo.InventoryRepository;
import com.harshit.Inventoryservice.service.InventoryService;

@Service
public class InventoryServiceImpl implements InventoryService{
@Autowired
	private InventoryRepository inventoryRepository;


public Inventory addinventory(Inventory inventory) {
	 return inventoryRepository.save(inventory);
	
}

public List<Inventory> getAllInventories() {
	
	return inventoryRepository.findAll();
}

public Inventory getInventory(String inId) {
	
	return inventoryRepository.findById(inId).get();
}

public void deleteInventory(String inId) {
	System.out.println("Deletedsuccesfully");
	inventoryRepository.deleteById(inId);
	
}

/*public Optional<Inventory> updateInventory(Inventory inventory,String inId) throws NotFoundException {
	
	Optional<Inventory> opInventory = inventoryRepository.findById(inId);
	if(!opInventory.isPresent()) {
		throw new NotFoundException();
	}
	Optional<Inventory> invent= opInventory.get();
	if(inventory.getInName() != null && !inventory.getInName().isEmpty())
	
	invent.setInName(inventory.getInName());
	invent.setPrice(inventory.getPrice());
	invent.setQuantity(inventory.getQuantity());
	
	 inventoryRepository.save(invent);
	 return invent;
}
*/
public Optional<Inventory> updateInventory( Inventory inventory,String inId) {
	
	Optional<Inventory> findById = inventoryRepository.findById(inId);
	if (findById.isPresent()) {
		Inventory userEntity = findById.get();
		if(inventory.getInName() != null && !inventory.getInName().isEmpty())
			userEntity.setInName(inventory.getInName());
			userEntity.setQuantity(inventory.getQuantity());
			userEntity.setPrice(inventory.getPrice());
		    inventoryRepository.save(userEntity);
	}
	return null;
	
}










}
