package com.example.rmbe.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "thay_doi")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Change {
    @Id
    @Column( name = "id")
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int id;

    @Column( name = "ngay_thay_doi")
    private Date date;

    @Column( name = "noi_dung")
    private String content;

    @ManyToOne( fetch = FetchType.EAGER)
    @JoinColumn( name = "ho_khau")
    private Department department;
}
