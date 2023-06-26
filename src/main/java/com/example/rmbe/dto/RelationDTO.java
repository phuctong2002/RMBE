package com.example.rmbe.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RelationDTO {
    private String id;
    private int department_id;
    private int person_id;
    private String person_name;
    private String relation;
}
