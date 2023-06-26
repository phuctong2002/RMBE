package com.example.rmbe.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table( name = "khoan_dong_gop")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DonationEvent {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column( name = "id")
    private int id;
    @Column( name = "ten")
    private String name;
}
