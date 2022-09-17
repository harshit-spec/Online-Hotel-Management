package com.harshit.UserManagement.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.harshit.UserManagement.Model.Guest;

@Repository
public interface GuestRepository extends MongoRepository<Guest,String>{

}
