package com.example.rmbe.service;

import com.example.rmbe.converter.DeadConverter;
import com.example.rmbe.converter.PersonConverter;
import com.example.rmbe.dto.DeadDTO;
import com.example.rmbe.dto.PersonDTO;
import com.example.rmbe.entity.Dead;
import com.example.rmbe.entity.Person;
import com.example.rmbe.repository.IDeadRepo;
import com.example.rmbe.repository.IPersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {
    @Autowired
    private IPersonRepo personRepo;
    @Autowired
    private PersonConverter personConverter;
    @Autowired
    private DeadConverter deadConverter;
    @Autowired
    private IDeadRepo deadRepo;
    public List<PersonDTO> getAll(){
        List<Person> persons = personRepo.findAll();
        System.out.println(persons.size());
        System.out.println(persons.get(0));
        return persons.stream().map( person -> personConverter.toDTO(person)).collect(Collectors.toList());
    }

    public void addUser(PersonDTO personDTO) {
        Person person = personConverter.toEntity(personDTO);
        personRepo.save(person);
    }

    public void addDead(DeadDTO deadDTO) {
        Person person = personRepo.findFirstById(deadDTO.getPerson_id());
        Dead dead = deadConverter.toEntity(deadDTO, person);
        deadRepo.save(dead);
    }

}
