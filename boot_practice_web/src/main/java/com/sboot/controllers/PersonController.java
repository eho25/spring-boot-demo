package com.sboot.controllers;

import com.sboot.services.models.PersonModel;
import com.sboot.services.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping(path="/")
    public String home(){
        return "Hello";
    }

    @GetMapping(path="/people")
    public List<PersonModel> getAllPeople(){
        return personService.getAllPeople();
    }

    @GetMapping(path="/test")
    public String testBatch(){
        personService.testBatch();
        return "Success?";
    }
}
