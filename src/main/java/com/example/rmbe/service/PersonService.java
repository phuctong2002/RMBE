package com.example.rmbe.service;

import com.example.rmbe.converter.DeadConverter;
import com.example.rmbe.converter.PersonConverter;
import com.example.rmbe.dto.DeadDTO;
import com.example.rmbe.dto.PersonDTO;
import com.example.rmbe.entity.Dead;
import com.example.rmbe.entity.Department;
import com.example.rmbe.entity.Person;
import com.example.rmbe.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private IPersonRepo personRepo;
    @Autowired
    private IDepartmentRepo departmentRepo;
    @Autowired
    private IDeadRepo deadRepo;
    @Autowired
    private IRelationRepo relationRepo;
    @Autowired
    private PersonConverter personConverter;
    @Autowired
    private DeadConverter deadConverter;
    @Autowired
    private IAbsenceRepo absenceRepo;
    public List<PersonDTO> getAll(){
        List<Person> persons = personRepo.findAll();
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

    public void deletePerson(int id) {
        deadRepo.deleteByPersonId(id);
        relationRepo.deleteByPersonId(id);
        Department department = departmentRepo.findFirstByPersonId(id);
        if (department != null)
            departmentService.deleteDepartment(department.getId());
        absenceRepo.deleteByPersonId(id);
        personRepo.deleteById(id);
    }

    public void updatePerson(int id, PersonDTO personDTO) {
        Person person = personRepo.findFirstById(id);
        if( person == null)
            return;
        Person newPerson = personConverter.toEntity(personDTO);
        newPerson.setId(id);
        personRepo.save(newPerson);
    }
}
