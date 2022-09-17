package com.harshit.Roommanagement.Repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.harshit.Roommanagement.Model.Room;

@Repository
public interface RoomRepository extends MongoRepository<Room,String>{

}
