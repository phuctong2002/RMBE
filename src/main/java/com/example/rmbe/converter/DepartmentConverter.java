package com.example.rmbe.converter;

import com.example.rmbe.dto.DepartmentDTO;
import com.example.rmbe.entity.Department;
import com.example.rmbe.entity.Person;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component

public class DepartmentConverter {
    @Autowired
    private ModelMapper modelMapper;
    public Department toEntity(DepartmentDTO departmentDTO, Person person) {
        if(departmentDTO == null)
            return null;
        Department department = modelMapper.map(departmentDTO, Department.class);
        department.setPerson(person);
        return department;
    }
    public DepartmentDTO toDTO( Department department){
        if( department == null)
            return null;
        DepartmentDTO departmentDTO = modelMapper.map(department, DepartmentDTO.class);
        departmentDTO.setPerson_id(department.getPerson().getId());
        departmentDTO.setPerson_name(department.getPerson().getName());
        return departmentDTO;
    }
}
