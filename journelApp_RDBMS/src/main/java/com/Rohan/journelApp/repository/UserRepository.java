package com.Rohan.journelApp.repository;

import com.Rohan.journelApp.entity.JournelEntry;
import com.Rohan.journelApp.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface UserRepository extends MongoRepository<User, ObjectId>{
    User findByUserName(String username);
}
