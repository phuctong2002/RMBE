package com.example.rmbe.service;

import com.example.rmbe.converter.PaymentConverter;
import com.example.rmbe.dto.PaymentDTO;
import com.example.rmbe.entity.Department;
import com.example.rmbe.entity.Payment;
import com.example.rmbe.entity.PaymentEvent;
import com.example.rmbe.repository.IDepartmentRepo;
import com.example.rmbe.repository.IPaymentEventRepo;
import com.example.rmbe.repository.IPaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentService {
    @Autowired
    private IPaymentEventRepo paymentEventRepo;
    @Autowired
    private IDepartmentRepo departmentRepo;
    @Autowired
    private IPaymentRepo paymentRepo;
    @Autowired
    private PaymentConverter paymentConverter;
    public void addPaymentEvent(PaymentEvent paymentEvent){
        PaymentEvent save = paymentEventRepo.save(paymentEvent);
    }

    public List<PaymentEvent> getAllEvents() {
        return paymentEventRepo.findAll();
    }


    public void addPayment(PaymentDTO paymentDTO) {
        PaymentEvent paymentEvent = paymentEventRepo.findFirstById(paymentDTO.getPaymentEvent_id());
        Department department = departmentRepo.findFirstById(paymentDTO.getDepartment_id());
        Payment payment = paymentConverter.toEntity(paymentDTO, department, paymentEvent);
        paymentRepo.save(payment);
    }

    public List<PaymentDTO> getAllPayments() {
        List<Payment> payments = paymentRepo.findAll();
        return payments.stream().map( payment -> paymentConverter.toDTO(payment)).collect(Collectors.toList());
    }

    public List<PaymentDTO> getPaymentsByEventId( int eventId) {
        List<Payment> payments = paymentRepo.findByEventId(eventId);
        return payments.stream().map( payment -> paymentConverter.toDTO(payment)).collect(Collectors.toList());
    }
}
