package com.example.rmbe.controller;

import com.example.rmbe.dto.UserDTO;
import com.example.rmbe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/")
    public ResponseEntity<Object> checkUser(@RequestBody UserDTO userDTO){
        UserDTO user = userService.getUser(userDTO);
        if( user == null)
            return new ResponseEntity<>( HttpStatus.UNAUTHORIZED);
        return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
    }
}
