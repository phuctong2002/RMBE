package com.example.rmbe.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AbsenceDTO {
    private int id;
    private Date start_date;
    private Date end_date;
    private String place;
    private String reason;
    private int person_id;
    private String person_name;
}
