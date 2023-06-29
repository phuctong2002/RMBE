package com.example.rmbe.service;

import com.example.rmbe.converter.DepartmentConverter;
import com.example.rmbe.converter.RelationConverter;
import com.example.rmbe.dto.ChangeDTO;
import com.example.rmbe.dto.DepartmentDTO;
import com.example.rmbe.dto.RelationDTO;
import com.example.rmbe.entity.Change;
import com.example.rmbe.entity.Department;
import com.example.rmbe.entity.Person;
import com.example.rmbe.entity.Relation;
import com.example.rmbe.repository.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartmentService {
    @Autowired
    private IChangeRepo changeRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private DepartmentConverter departmentConverter;
    @Autowired
    private ISojournRepo sojournRepo;
    @Autowired
    private IDonationRepo donationRepo;
    @Autowired
    private IPaymentRepo paymentRepo;
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
        Department department = departmentRepo.save(departmentConverter.toEntity(departmentDTO, person));
        RelationDTO relationDTO = new RelationDTO();
        relationDTO.setDepartment_id(department.getId());
        relationDTO.setPerson_id(department.getPerson().getId());
        relationDTO.setRelation("Chu ho");
        addChange("Tao ho khau moi voi chu ho " + departmentDTO.getPerson_name(), department);
        addRelation(relationDTO);
    }
    public List<DepartmentDTO> getAllDepartments(){
        List<Department> departments = departmentRepo.findAll();
        return departments.stream().map( department -> departmentConverter.toDTO(department)).collect(Collectors.toList());
    }
    public void deleteDepartment(int id){
        Department department = departmentRepo.findFirstById(id);
        paymentRepo.deleteByDepartmentId(department.getId());
        donationRepo.deleteByDepartmentId(department.getId());
        List<Relation> relations = relationRepo.findByDepartment(department);
        List<Integer> relationIds = relations.stream().map(relation -> relation.getId()).collect(Collectors.toList());
        for(int relationId : relationIds){
            relationRepo.deleteById(relationId);
        }
        sojournRepo.deleteByDepartmentId(department.getId());
        changeRepo.deleteByDepartmentId(department.getId());
        departmentRepo.deleteById(id);
    }

    public List<RelationDTO> getRelationByDepartment(int id){
        List<Relation> relations = relationRepo.getByDepartment(id);
        return relations.stream().map(relation -> relationConverter.toDTO(relation)).collect(Collectors.toList());
    }

    public void addRelation(RelationDTO relationDTO) {
        Person person = personRepo.findFirstById(relationDTO.getPerson_id());
        Department department = departmentRepo.findFirstById(relationDTO.getDepartment_id());
        addChange("them thanh vien " + person.getName() , department);
        relationRepo.save(relationConverter.toEntity(relationDTO, person, department));
    }

    public DepartmentDTO changeDepartment(DepartmentDTO departmentDTO) {
        Department department = departmentRepo.findFirstById(departmentDTO.getId());
        if( department.getPerson().getId() != departmentDTO.getPerson_id()){
            relationRepo.deleteByDepartmentId(departmentDTO.getId());
            RelationDTO relationDTO = new RelationDTO();
            relationDTO.setDepartment_id(department.getId());
            relationDTO.setPerson_id(departmentDTO.getPerson_id());
            relationDTO.setRelation("Chu ho");
            addRelation(relationDTO);
        }
        department.setPerson(personRepo.findFirstById(departmentDTO.getPerson_id()));
        department.setAddress(departmentDTO.getAddress());
        return departmentConverter.toDTO(departmentRepo.save(department));
    }

    public List<ChangeDTO> getChanges(int departmentId) {
        List<Change> changes = changeRepo.findByDepartmentId(departmentId);
        return changes.stream().map(change -> modelMapper.map(change, ChangeDTO.class)).collect(Collectors.toList());
    }
    public void addChange( String content, Department department){
        Change change = new Change();
        change.setDepartment(department);
        change.setDate(new Date());
        change.setContent(content);
        changeRepo.save(change);
    }

}
