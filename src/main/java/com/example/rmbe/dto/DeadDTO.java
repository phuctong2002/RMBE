package com.example.rmbe.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeadDTO {
    private int person_id;
    private Date date_of_death;
    private String reason;
}
