package com.example.rmbe.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ho_khau")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "dia_chi")
    private String address;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "chu_ho")
    private Person person;
}
