package com.example.rmbe.controller;

import com.example.rmbe.dto.PaymentDTO;
import com.example.rmbe.entity.PaymentEvent;
import com.example.rmbe.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @PostMapping("")
    public ResponseEntity<Object> addPayment(@RequestBody PaymentDTO paymentDTO){
        paymentService.addPayment(paymentDTO);
        return null;
    }
    @GetMapping("/")
    public ResponseEntity<Object> getPayments(){
        return new ResponseEntity<>( paymentService.getAllPayments(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> getPayments(@PathVariable int id){
        return new ResponseEntity<>( paymentService.getPaymentsByEventId( id), HttpStatus.OK);
    }

}
