package com.example.rmbe.converter;

import com.example.rmbe.dto.SojournDTO;
import com.example.rmbe.entity.Department;
import com.example.rmbe.entity.Sojourn;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SojournConverter {
    @Autowired
    private ModelMapper modelMapper;
    public Sojourn toEntity(SojournDTO sojournDTO, Department department){
        if(sojournDTO == null)
            return null;
        Sojourn sojourn = modelMapper.map(sojournDTO, Sojourn.class);
        sojourn.setDepartment(department);
        return sojourn;
    }
    public SojournDTO toDTO( Sojourn sojourn) {
        SojournDTO sojournDTO = modelMapper.map(sojourn, SojournDTO.class);
        sojournDTO.setDepartment_id(sojourn.getDepartment().getId());
        sojournDTO.setPerson_of_department(sojourn.getDepartment().getPerson().getName());
        return sojournDTO;
    }

}
