package com.example.rmbe.service;

import com.example.rmbe.entity.PaymentEvent;
import com.example.rmbe.repository.IPaymentEventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {
    @Autowired
    private IPaymentEventRepo paymentEventRepo;
    public void addPaymentEvent(PaymentEvent paymentEvent){
        PaymentEvent save = paymentEventRepo.save(paymentEvent);
    }

    public List<PaymentEvent> getAllEvents() {
        return paymentEventRepo.findAll();
    }
}
