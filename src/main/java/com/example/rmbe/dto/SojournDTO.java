package com.example.rmbe.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SojournDTO {
    private int id;
    private int department_id;
    private String name;
    private String person_of_department;
    private Date start_date;
    private Date end_date;
    private String reason;
}
