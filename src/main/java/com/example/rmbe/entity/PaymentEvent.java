package com.example.rmbe.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.annotation.Target;

@Entity
@Table( name = "khoan_thu")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentEvent {
    @Id
    @Column( name = "id")
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int id;
    @Column( name = "ten")
    private String name;
    @Column( name = "so_tien")
    private int aom;
}
