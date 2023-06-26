package com.example.rmbe.controller;

import com.example.rmbe.entity.PaymentEvent;
import com.example.rmbe.service.PaymentService;
import jakarta.persistence.GeneratedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping("/event")
    public ResponseEntity<Object> addEvent(@RequestBody PaymentEvent paymentEvent){
        paymentService.addPaymentEvent(paymentEvent);
        return null;
    }
    @GetMapping("/event/")
    public ResponseEntity<Object> getAllEvents(){
        return new ResponseEntity<>(paymentService.getAllEvents(), HttpStatus.OK);
    }

}
