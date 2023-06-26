package com.example.rmbe.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table( name = "nhan_khau")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column(name = "id")
    private int id;
    @Column(name = "ho_ten")
    private String name;
    @Column( name = "gioi_tinh")
    private String gender;
    @Column( name = "ngay_sinh")
    private Date birth;
    @Column(name = "bi_danh")
    private String alias;
    @Column( name = "nguyen_quan")
    private String home_town;
    @Column(name = "dan_toc")
    private String nation;
    @Column(name = "nghe_nghiep")
    private String job;
    @Column(name = "noi_lam_viec")
    private String workspace;
    @Column( name = "ghi_chu")
    private String note;
    @Column( name = "cccd")
    private String id_card;
    @Column( name = "ngay_cap")
    private Date created_at;
    @Column( name = "noi_cap")
    private String issued_by;
}
