package com.example.rmbe.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "dong_tien")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column( name = "id")
    private int id;
    @Column( name = "ngay_dong")
    private Date date;
    @ManyToOne( fetch = FetchType.EAGER)
    @JoinColumn( name = "khoan_thu")
    private PaymentEvent paymentEvent;
    @ManyToOne( fetch = FetchType.EAGER)
    @JoinColumn( name = "ho_khau")
    private Department department;
}
