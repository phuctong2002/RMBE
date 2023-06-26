package com.example.rmbe.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.boot.model.source.spi.PluralAttributeElementSourceOneToMany;

import java.util.Date;

@Entity
@Table( name = "khai_tu")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dead {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "ngay_mat")
    private Date date_of_death;
    @Column(name = "li_do")
    private String reason;
    @OneToOne( fetch = FetchType.EAGER)
    @JoinColumn(name = "nhan_khau")
    private Person person;
}
