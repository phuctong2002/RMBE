package com.example.rmbe.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table( name = "tai_khoan")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    @Column( name = "id")
    private int id;
    @Column( name = "ten_dang_nhap")
    private String username;
    @Column( name = "mat_khau")
    private String password;
}
