package com.example.rmbe.converter;

import com.example.rmbe.dto.AbsenceDTO;
import com.example.rmbe.entity.Absence;
import com.example.rmbe.entity.Person;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AbsenceConverter {
    @Autowired
    private ModelMapper modelMapper;
    public AbsenceDTO toDTO(Absence absence){
        if( absence  == null)
            return null;
        AbsenceDTO absenceDTO = modelMapper.map(absence, AbsenceDTO.class);
        absenceDTO.setPerson_id(absence.getPerson().getId());
        absenceDTO.setPerson_name(absence.getPerson().getName());
        return absenceDTO;
    }

    public Absence toEntity(AbsenceDTO absenceDTO, Person person) {
        Absence absence = modelMapper.map(absenceDTO, Absence.class);
        absence.setPerson(person);
        return absence;
    }
}
