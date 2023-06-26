package com.example.rmbe.converter;

import com.example.rmbe.dto.PersonDTO;
import com.example.rmbe.entity.Person;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;

@Component
public class PersonConverter {
    @Autowired
    private ModelMapper modelMapper;
    public PersonDTO toDTO(Person person){
        if( person == null )
            return null;
        PersonDTO personDTO = modelMapper.map(person, PersonDTO.class);
        return personDTO;
    }
    public Person toEntity(PersonDTO personDTO){
        if( personDTO == null)
            return null;
        return modelMapper.map(personDTO, Person.class);
    }
}
