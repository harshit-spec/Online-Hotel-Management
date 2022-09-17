package com.harshit.UserManagement.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.harshit.UserManagement.Model.Receptionist;

@Repository
public interface ReceptionistRepository extends MongoRepository<Receptionist,String>{

}
