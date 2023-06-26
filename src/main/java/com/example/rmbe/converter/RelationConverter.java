package com.example.rmbe.converter;

import com.example.rmbe.dto.RelationDTO;
import com.example.rmbe.entity.Department;
import com.example.rmbe.entity.Person;
import com.example.rmbe.entity.Relation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RelationConverter {
    @Autowired
    private ModelMapper modelMapper;
    public RelationDTO toDTO(Relation relation){
        RelationDTO relationDTO = modelMapper.map(relation, RelationDTO.class);
        relationDTO.setDepartment_id(relation.getDepartment().getId());
        relationDTO.setPerson_id(relation.getPerson().getId());
        relationDTO.setPerson_name(relation.getPerson().getName());
        return relationDTO;
    }

    public Relation toEntity(RelationDTO relationDTO, Person person, Department department) {
        if( relationDTO == null)
            return null;
        Relation relation = modelMapper.map(relationDTO, Relation.class);
        relation.setDepartment(department);
        relation.setPerson(person);
        return relation;
    }
}
