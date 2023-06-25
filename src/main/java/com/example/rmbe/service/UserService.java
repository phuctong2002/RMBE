package com.example.rmbe.service;

import com.example.rmbe.converter.UserConverter;
import com.example.rmbe.dto.UserDTO;
import com.example.rmbe.entity.User;
import com.example.rmbe.repository.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserConverter userConverter;
    @Autowired
    private IUserRepo userRepo;
    public UserDTO getUser( UserDTO userDTO){
        System.out.println(userDTO.getUsername() + " " + userDTO.getPassword());
        User user = userRepo.findByUsernameAndPassword( userDTO.getUsername(), userDTO.getPassword());
        System.out.println(user.getUsername() + " " + user.getPassword());
        return userConverter.toDTO(user);
    }
}
