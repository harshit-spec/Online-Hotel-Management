package com.harshit.Inventoryservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.harshit.Inventoryservice.model.Inventory;
import com.harshit.Inventoryservice.serviceImpl.InventoryServiceImpl;


@RestController
@RequestMapping("/inventory")
public class InventoryController {
@Autowired
private InventoryServiceImpl inventoryService;
@PostMapping("/add")
public Inventory addDetails(@RequestBody Inventory inventory) {
	return inventoryService.addinventory(inventory);
}
@GetMapping("/list")
public List<Inventory> getAllInventory() {
	return inventoryService.getAllInventories();
}
@GetMapping("/{inId}")
public Inventory getInventory(@PathVariable String inId) {
	return inventoryService.getInventory(inId);
}

@DeleteMapping("/{inId}")
public void deleteInventory(@PathVariable String inId) {
	inventoryService.deleteInventory(inId);
}
@PutMapping("/update/{inId}")
public Optional<Inventory> updateInventory(@RequestBody Inventory inventory,@PathVariable String inId)  {
	return inventoryService.updateInventory(inventory, inId);
}



}

