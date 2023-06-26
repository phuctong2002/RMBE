package com.example.rmbe.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "tam_tru")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sojourn {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "id")
    private int id;
    @Column(name = "ho_ten")
    private String name;
    @Column( name = "ngay_bat_dau")
    private Date start_date;
    @Column( name = "ngay_ket_thuc")
    private Date end_date;
    @Column( name = "li_do")
    private String reason;
    @ManyToOne( fetch = FetchType.EAGER)
    @JoinColumn( name = "ho_khau")
    private Department department;
}
