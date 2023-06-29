package com.example.rmbe.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {
    private int id;
    private String name;
    private Date birth;
    private String alias;
    private String gender;
    private String home_town;
    private String nation;
    private String job;
    private String workspace;
    private String note;
    private String id_card;
    private String issued_by;
    private Date created_at;
    private String address;
}
