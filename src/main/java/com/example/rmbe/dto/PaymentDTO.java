package com.example.rmbe.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDTO {
    private int id;
    private Date date;
    private int paymentEvent_id;
    private int department_id;
    private String department_name;
}
