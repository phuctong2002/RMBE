package com.example.rmbe.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.web.bind.annotation.GetMapping;

@Entity
@Table(name = "quan_he")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Relation {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column( name = "quan_he")
    private String relation;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "nhan_khau")
    private Person person;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ho_khau")
    private Department department;
}
