package com.harshit.UserManagement.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.harshit.UserManagement.Model.Manager;
@Repository
public interface ManagerRepository extends MongoRepository<Manager,String>{

	Manager findByUsername(String username);

}
