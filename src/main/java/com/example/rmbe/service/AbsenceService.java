package com.example.rmbe.service;

import com.example.rmbe.converter.AbsenceConverter;
import com.example.rmbe.dto.AbsenceDTO;
import com.example.rmbe.entity.Absence;
import com.example.rmbe.entity.Person;
import com.example.rmbe.repository.IAbsenceRepo;
import com.example.rmbe.repository.IPersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AbsenceService {
    @Autowired
    private IAbsenceRepo absenceRepo;
    @Autowired
    private IPersonRepo personRepo;
    @Autowired
    private AbsenceConverter absenceConverter;

    public List<AbsenceDTO> getAllAbsenceDTOs() {
        List<Absence> absences = absenceRepo.findAll();
        return absences.stream().map(absence -> absenceConverter.toDTO(absence)).collect(Collectors.toList());
    }

    public void addAbsence(AbsenceDTO absenceDTO) {
        Person person = personRepo.findFirstById(absenceDTO.getPerson_id());

        absenceRepo.save(absenceConverter.toEntity(absenceDTO, person));
    }

    public void deleteAbsence(int id) {
        absenceRepo.deleteById(id);
    }
}
