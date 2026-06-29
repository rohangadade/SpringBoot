package com.Rohan.journelApp.repository;

import com.Rohan.journelApp.entity.JournelEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface JournelEntryRepository extends MongoRepository<JournelEntry, ObjectId>{


}
