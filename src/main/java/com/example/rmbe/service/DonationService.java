package com.example.rmbe.service;

import com.example.rmbe.converter.DonationConverter;
import com.example.rmbe.dto.DonationDTO;
import com.example.rmbe.entity.Department;
import com.example.rmbe.entity.Donation;
import com.example.rmbe.entity.DonationEvent;
import com.example.rmbe.repository.IDepartmentRepo;
import com.example.rmbe.repository.IDonationEventRepo;
import com.example.rmbe.repository.IDonationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DonationService {
    @Autowired
    private IDonationEventRepo donationEventRepo;
    @Autowired
    private IDepartmentRepo departmentRepo;
    @Autowired
    private IDonationRepo donationRepo;
    @Autowired
    private DonationConverter donationConverter;

    public List<DonationEvent> getDonationEvents(){
        return donationEventRepo.findAll();
    }

    public void addDonationEvent(DonationEvent donationEvent){
        donationEventRepo.save(donationEvent);
    }

    public DonationDTO addDonation(DonationDTO donationDTO) {
        Department department = departmentRepo.findFirstById(donationDTO.getDepartment_id());
        DonationEvent donationEvent = donationEventRepo.findFirstById(donationDTO.getDonationEvent_id());
        Donation donation = donationConverter.toEntity(donationDTO, donationEvent, department);
        return donationConverter.toDTO(donationRepo.save(donation));
    }

    public List<DonationDTO> getDonationByEventId(int id) {
        List<Donation> donations = donationRepo.findByEventId(id);
        return donations.stream().map(donation -> donationConverter.toDTO(donation)).collect(Collectors.toList());
    }
}
