package com.example.rmbe.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table( name = "tam_vang")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Absence {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column( name = "id")
    private int id;

    @Column( name = "tu_ngay")
    private Date start_date;

    @Column( name = "den_ngay")
    private Date end_date;
    @Column( name = "dia_diem")
    private String place;
    @Column( name = "li_do")
    private String reason;

    @ManyToOne( fetch = FetchType.EAGER)
    @JoinColumn( name = "nhan_khau")
    private Person person;
}
