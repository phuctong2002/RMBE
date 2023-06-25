package com.example.rmbe.converter;

import com.example.rmbe.dto.UserDTO;
import com.example.rmbe.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {
    private ModelMapper modelMapper;
    public UserConverter() {}{
        modelMapper = new ModelMapper();
    }

    public UserDTO toDTO(User user){
        if( user == null) return null;
        return modelMapper.map(user, UserDTO.class);
    }
    public User toEntity( UserDTO userDTO){
        if( userDTO == null) return null;
        return modelMapper.map(userDTO, User.class);
    }
}
