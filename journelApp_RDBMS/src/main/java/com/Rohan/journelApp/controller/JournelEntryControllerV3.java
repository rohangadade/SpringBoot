package com.Rohan.journelApp.controller;

import com.Rohan.journelApp.entity.JournelEntry;
import com.Rohan.journelApp.service.JournelEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController  //
@RequestMapping("/_journel")
public class JournelEntryControllerV3 {

    @Autowired
    private JournelEntryService journelEntryService;

    @GetMapping   //GET
    public ResponseEntity<?> getAll(){
        List<JournelEntry> all = journelEntryService.getAll();
        if(all != null && !all.isEmpty()){
            return new ResponseEntity<>(all,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);


    }

    @PostMapping  //POST
    public ResponseEntity<JournelEntry> createEntry(@RequestBody JournelEntry myEntry){
        try{   
            myEntry.setDate(LocalDateTime.now());
            journelEntryService.saveEntry(myEntry);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("id/{myId}")
    public ResponseEntity<?>getJournelEntryById(@PathVariable ObjectId myId){
       Optional<JournelEntry>journelEntry = journelEntryService.findById(myId);
       if(journelEntry.isPresent()){
           return new ResponseEntity<>(journelEntry.get(),HttpStatus.OK);
       }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("id/{myId}")
    public ResponseEntity<?> deleteJournelEntryById(@PathVariable ObjectId myId){
        journelEntryService.deleteById(myId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    @PutMapping("/id/{id}")
    public ResponseEntity<?> updateJournelById(@PathVariable ObjectId id , @RequestBody JournelEntry newEntry) {

        JournelEntry old = journelEntryService.findById(id).orElse(null);
        if (old != null) {
            old.setTitle(newEntry.getTitle() != null && !newEntry.getTitle().equals("") ? newEntry.getTitle() : old.getTitle());
            old.setContent(newEntry.getContent() != null && !newEntry.equals("") ? newEntry.getContent() : old.getContent());
            return new ResponseEntity<>(old, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
