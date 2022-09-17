package com.harshit.UserManagement.Repository;



import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.harshit.UserManagement.Model.Users;

@Repository
public interface UserRepository extends MongoRepository<Users,String> {

}
