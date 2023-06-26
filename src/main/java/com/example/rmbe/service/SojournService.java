package com.example.rmbe.service;

import com.example.rmbe.converter.SojournConverter;
import com.example.rmbe.dto.SojournDTO;
import com.example.rmbe.entity.Department;
import com.example.rmbe.entity.Sojourn;
import com.example.rmbe.repository.IDepartmentRepo;
import com.example.rmbe.repository.ISojournRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SojournService {
    @Autowired
    private ISojournRepo sojournRepo;
    @Autowired
    private SojournConverter sojournConverter;
    @Autowired
    private IDepartmentRepo departmentRepo;

    public void saveSojourn(SojournDTO sojournDTO) {
        Department department = departmentRepo.findFirstById(sojournDTO.getDepartment_id());
        Sojourn result = sojournRepo.save(sojournConverter.toEntity(sojournDTO, department));
    }

        public List<SojournDTO> getAllSojourn() {
        List<Sojourn> sojourns = sojournRepo.findAll();
        return sojourns.stream().map(sojourn -> sojournConverter.toDTO(sojourn)).collect(Collectors.toList());
    }
}
