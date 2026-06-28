package com.Rohan.journelApp.service;

import com.Rohan.journelApp.entity.JournelEntry;
import com.Rohan.journelApp.repository.JournelEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Component
public class JournelEntryService {

    @Autowired
    private JournelEntryRepository journelEntryRepository;

    public void saveEntry(JournelEntry journelEntry){

        journelEntryRepository.save(journelEntry);
    }

    public List<JournelEntry> getAll(){
        return journelEntryRepository.findAll();

    }

    public Optional<JournelEntry> findById(ObjectId id){

        return journelEntryRepository.findById(id);
    }

    public void deleteById(ObjectId id){

        journelEntryRepository.deleteById(id);
    }

}



//controller --->services ---> repository
//          calls          calls