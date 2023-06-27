package com.example.rmbe.repository;

import com.example.rmbe.entity.PaymentEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPaymentEventRepo extends JpaRepository<PaymentEvent, Integer> {
    PaymentEvent findFirstById(int paymentEvent_id);
}
