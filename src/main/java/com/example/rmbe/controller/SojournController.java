package com.example.rmbe.controller;

import com.example.rmbe.dto.SojournDTO;
import com.example.rmbe.service.SojournService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/sojourn")
public class SojournController {
    @Autowired
    private SojournService sojournService;
    @PostMapping("")
    public ResponseEntity<Object> addSojourn(@RequestBody SojournDTO sojournDTO){
        sojournService.saveSojourn(sojournDTO);
        return null;
    }
    @GetMapping("/")
    public ResponseEntity<Object> getAllSojourn(){
        return new ResponseEntity<>(sojournService.getAllSojourn(), HttpStatus.OK);
    }
}
