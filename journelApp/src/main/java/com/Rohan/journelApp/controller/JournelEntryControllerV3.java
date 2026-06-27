package com.Rohan.journelApp.controller;

import com.Rohan.journelApp.entity.JournelEntry;
import com.Rohan.journelApp.service.JournelEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController  //
@RequestMapping("/journel")
public class JournelEntryControllerV3 {

    @Autowired
    private JournelEntryService journelEntryService;

    @GetMapping   //GET
    public List<JournelEntry> getAll(){
        return journelEntryService.getAll();

    }

    @PostMapping  //POST
    public JournelEntry createEntry(@RequestBody JournelEntry myEntry){
        myEntry.setDate(LocalDateTime.now());
        journelEntryService.saveEntry(myEntry);
        return myEntry;
    }

    @GetMapping("id/{myId}")
    public JournelEntry getJournelEntryById(@PathVariable ObjectId myId){
        return journelEntryService.findById(myId).orElse(null);

    }

    @DeleteMapping("id/{myId}")
    public boolean deleteJournelEntryById(@PathVariable ObjectId myId){
        journelEntryService.deleteById(myId);
        return true;
    }

    @PutMapping("/id/{id}")
    public JournelEntry updateJournelById(@PathVariable ObjectId id , @RequestBody JournelEntry newEntry){

        JournelEntry old = journelEntryService.findById(id).orElse(null);
        if(old != null)
        {
            old.setTitle(newEntry.getTitle() != null && !newEntry.getTitle().equals("") ? newEntry.getTitle() : old.getTitle());
            old.setContent(newEntry.getContent() != null && !newEntry.equals("") ? newEntry.getContent() : old.getContent());
        }
        journelEntryService.saveEntry(old);

        return old;
    }
}
