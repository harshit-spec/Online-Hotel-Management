package com.harshit.Roommanagement.Repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.harshit.Roommanagement.Model.Reservation;
@Repository
public interface ReservationRepository extends MongoRepository<Reservation,String> {

}
