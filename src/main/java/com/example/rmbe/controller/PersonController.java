package com.example.rmbe.controller;

import com.example.rmbe.dto.DeadDTO;
import com.example.rmbe.dto.PersonDTO;
import com.example.rmbe.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonService personService;
    @GetMapping("/")
    public ResponseEntity<Object> getAll(){
        return new ResponseEntity<>( personService.getAll(), HttpStatus.OK);
    }
    @PostMapping("")
    public ResponseEntity<Object> addPerson(@RequestBody PersonDTO personDTO){
        System.out.println(personDTO);
        personService.addUser(personDTO);
        return null;
    }
    @PostMapping("/dead")
    public ResponseEntity<Object> addDead(@RequestBody DeadDTO deadDTO){
        personService.addDead(deadDTO);
        return null;
    }

}
