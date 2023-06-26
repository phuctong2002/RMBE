package com.example.rmbe.controller;

import com.example.rmbe.dto.AbsenceDTO;
import com.example.rmbe.service.AbsenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/absence")
@CrossOrigin
public class AbsenceController {
    @Autowired
    private AbsenceService service;
    @GetMapping("/")
    public ResponseEntity<Object> getAllAbsences(){
        return new ResponseEntity<>( service.getAllAbsenceDTOs(), HttpStatus.OK);
    }
    @PostMapping("")
    public ResponseEntity<Object> addAbsence(@RequestBody AbsenceDTO absenceDTO){
        service.addAbsence(absenceDTO);
        return null;
    }
}
