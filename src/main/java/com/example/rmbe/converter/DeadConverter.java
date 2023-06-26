package com.example.rmbe.converter;

import com.example.rmbe.dto.DeadDTO;
import com.example.rmbe.entity.Dead;
import com.example.rmbe.entity.Person;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeadConverter {
    @Autowired
    private ModelMapper modelMapper;
    public Dead toEntity(DeadDTO deadDTO, Person person){
        if( deadDTO == null)
            return null;
        Dead dead = modelMapper.map(deadDTO, Dead.class);
        dead.setPerson(person);
        return dead;
    }
}
