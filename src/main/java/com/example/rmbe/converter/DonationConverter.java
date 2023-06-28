package com.example.rmbe.converter;

import com.example.rmbe.dto.DonationDTO;
import com.example.rmbe.entity.Department;
import com.example.rmbe.entity.Donation;
import com.example.rmbe.entity.DonationEvent;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DonationConverter {
    @Autowired
    private ModelMapper modelMapper;
    public Donation toEntity(DonationDTO donationDTO, DonationEvent donationEvent, Department department){
        Donation donation = modelMapper.map( donationDTO , Donation.class);
        donation.setDonationEvent(donationEvent);
        donation.setDepartment(department);
        return donation;
    }
    public DonationDTO toDTO(Donation donation){
        DonationDTO donationDTO = modelMapper.map(donation, DonationDTO.class);
        donationDTO.setDonationEvent_id(donation.getDonationEvent().getId());
        donationDTO.setDepartment_id(donation.getDepartment().getId());
        donationDTO.setDepartment_name(donation.getDepartment().getPerson().getName());
        return donationDTO;
    }
}
