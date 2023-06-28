package com.example.rmbe.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "dong_khoan_dong_gop")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Donation {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column( name = "id")
    private int id;
    @Column( name = "ngay_dong")
    private Date date;
    @Column( name = "so_tien")
    private int price;
    @ManyToOne( fetch = FetchType.EAGER)
    @JoinColumn( name = "ho_khau")
    private Department department;
    @ManyToOne( fetch = FetchType.EAGER)
    @JoinColumn( name = "khoan_dong_gop")
    private DonationEvent donationEvent;
}
