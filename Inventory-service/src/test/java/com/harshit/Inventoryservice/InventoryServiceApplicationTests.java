package com.harshit.Inventoryservice;

import static org.assertj.core.api.Assertions.offset;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.test.context.junit4.SpringRunner;

import com.harshit.Inventoryservice.model.Inventory;
import com.harshit.Inventoryservice.repo.InventoryRepository;
import com.harshit.Inventoryservice.serviceImpl.InventoryServiceImpl;

@SpringBootTest
@RunWith(SpringRunner.class)
class InventoryServiceApplicationTests {
	
	@MockBean
private InventoryRepository inventoryRepository;
	@Autowired
private InventoryServiceImpl inventoryService;
	
@Test
	public void getitemsTest() {
		when(inventoryRepository.findAll()).thenReturn(Stream.of(new Inventory("1","screw",50,500),
				new Inventory("2","driver",5,500)).collect(Collectors.toList()));
		assertEquals(2, inventoryService.getAllInventories().size());
	}
@Test
public void getitemsTest_1() {
	when(inventoryRepository.findAll()).thenReturn(Stream.of(new Inventory("1","screw",50,500),
			new Inventory("2","driver",5,500)).collect(Collectors.toList()));
	assertEquals(3, inventoryService.getAllInventories().size());
}
@Test
public void saveTest() {
	Inventory invent = new Inventory("1","screw",50,500);
	when(inventoryRepository.save(invent)).thenReturn(invent);
	assertEquals(invent,inventoryService.addinventory(invent));
}
@Test
public void saveTest_1() {
	Inventory invent = new Inventory("1","screw",50,500);
	Inventory inventory = new Inventory("2","drivers",52,52220);
	when(inventoryRepository.save(invent)).thenReturn(invent);
	assertEquals(inventory,inventoryService.addinventory(invent));
}
@Test
public void deleteTest() {
	Inventory inventory = new Inventory("1","screw",50,500);
	inventoryService.deleteInventory("1");
	verify(inventoryRepository,times(1)).deleteById("1");
}
@Test
public void deleteTest_1() {
	Inventory inventory = new Inventory("1","screw",50,500);
	Inventory invent = new Inventory("2","drivers",60,5600);
	inventoryService.deleteInventory("1");
	verify(inventoryRepository,times(2)).deleteById("2");
}
@Test
public void updateTest() throws NotFoundException {
	Inventory invent = new Inventory("2","wrench",10,1000);
	String id = invent.getInId();
	invent.setPrice(10000);
	inventoryRepository.save(invent);
	when(inventoryRepository.findById(id)).thenReturn(Optional.of(invent));
	assertEquals(invent,inventoryService.updateInventory(invent, id));
}
@Test
public void getItemTest() {
	Inventory inventory = new Inventory("2","soap",200,20000);

	when(inventoryRepository.findById(anyString())).thenReturn(Optional.of(inventory));
	assertEquals(inventory,inventoryService.getInventory("id"));
}

}