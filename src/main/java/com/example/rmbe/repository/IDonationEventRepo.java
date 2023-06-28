package com.example.rmbe.repository;

import com.example.rmbe.entity.DonationEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDonationEventRepo extends JpaRepository<DonationEvent, Integer> {
    DonationEvent findFirstById(int donationEvent_id);
}
