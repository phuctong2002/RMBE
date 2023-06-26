package com.example.rmbe.service;

import com.example.rmbe.converter.DepartmentConverter;
import com.example.rmbe.converter.RelationConverter;
import com.example.rmbe.dto.DepartmentDTO;
import com.example.rmbe.dto.RelationDTO;
import com.example.rmbe.entity.Department;
import com.example.rmbe.entity.Person;
import com.example.rmbe.entity.Relation;
import com.example.rmbe.repository.IDepartmentRepo;
import com.example.rmbe.repository.IPersonRepo;
import com.example.rmbe.repository.IRelationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentConverter departmentConverter;
    @Autowired
    private RelationConverter relationConverter;
    @Autowired
    private IDepartmentRepo departmentRepo;
    @Autowired
    private IPersonRepo personRepo;
    @Autowired
    private IRelationRepo relationRepo;
    public void addDepartment(DepartmentDTO departmentDTO){
        Person person = personRepo.findFirstById(departmentDTO.getPerson_id());
        departmentRepo.save(departmentConverter.toEntity(departmentDTO, person));
    }
    public List<DepartmentDTO> getAllDepartments(){
        List<Department> departments = departmentRepo.findAll();
        return departments.stream().map( department -> departmentConverter.toDTO(department)).collect(Collectors.toList());
    }
    public void deleteDepartment(int id){
        departmentRepo.deleteById(id);
    }

    public List<RelationDTO> getRelationByDepartment(int id){
        List<Relation> relations = relationRepo.getByDepartment(id);
        return relations.stream().map(relation -> relationConverter.toDTO(relation)).collect(Collectors.toList());
    }

    public void addRelation(RelationDTO relationDTO) {
        Person person = personRepo.findFirstById(relationDTO.getPerson_id());
        Department department = departmentRepo.findFirstById(relationDTO.getDepartment_id());
        relationRepo.save(relationConverter.toEntity(relationDTO, person, department));
    }
}
