package com.example.rmbe.controller;

import com.example.rmbe.dto.DonationDTO;
import com.example.rmbe.entity.DonationEvent;
import com.example.rmbe.service.DonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/donation")
public class DonationController {
    @Autowired
    private DonationService donationService;
    @GetMapping("/event/")
    public ResponseEntity<Object> getDonationEvent(){
        return new ResponseEntity<>(donationService.getDonationEvents(), HttpStatus.OK);

    }
    @PostMapping("/event")
    public ResponseEntity<Object> addDonationEvent(@RequestBody DonationEvent donationEvent){
        donationService.addDonationEvent(donationEvent);
        return null;
    }

    @PostMapping("")
    public ResponseEntity<Object> addDonation(@RequestBody DonationDTO donationDTO){
        return new ResponseEntity<>(donationService.addDonation(donationDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getDonationByEventId(@PathVariable int id){
        return new ResponseEntity<>(donationService.getDonationByEventId(id), HttpStatus.OK);
    }

}
