package com.example.rmbe.service;

import com.example.rmbe.entity.DonationEvent;
import com.example.rmbe.repository.IDonationEventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonationService {
    @Autowired
    private IDonationEventRepo donationEventRepo;

    public List<DonationEvent> getDonationEvents(){
        return donationEventRepo.findAll();
    }

    public void addDonationEvent(DonationEvent donationEvent){
        donationEventRepo.save(donationEvent);
    }

}
