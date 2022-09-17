package com.harshit.UserManagement.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.harshit.UserManagement.Model.Owner;
@Repository
public interface OwnerRepository extends MongoRepository<Owner,String> {


	Owner findByUserName(String username);

}
