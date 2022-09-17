package com.harshit.Inventoryservice.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.harshit.Inventoryservice.model.Inventory;

@Repository
public interface InventoryRepository extends MongoRepository<Inventory,String> {

}
