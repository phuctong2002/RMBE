package com.example.rmbe.converter;

import com.example.rmbe.dto.PaymentDTO;
import com.example.rmbe.entity.Department;
import com.example.rmbe.entity.Payment;
import com.example.rmbe.entity.PaymentEvent;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaymentConverter {
    @Autowired
    private ModelMapper modelMapper;
    public Payment toEntity(PaymentDTO paymentDTO, Department department, PaymentEvent paymentEvent){
        if( paymentDTO == null)
            return null;
        Payment payment = modelMapper.map(paymentDTO, Payment.class);
        payment.setPaymentEvent(paymentEvent);
        payment.setDepartment(department);
        return payment;
    }
    public PaymentDTO toDTO( Payment payment){
        PaymentDTO paymentDTO = modelMapper.map( payment, PaymentDTO.class );
        paymentDTO.setPaymentEvent_id(payment.getPaymentEvent().getId());
        paymentDTO.setDepartment_id(payment.getDepartment().getId());
        paymentDTO.setDepartment_name(payment.getDepartment().getPerson().getName());
        return paymentDTO;
    }
}
