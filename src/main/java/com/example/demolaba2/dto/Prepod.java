package com.example.demolaba2.dto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "prepod")
public class Prepod {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prepod_seq")
    private Integer id;

    @Column(name = "fio")
    private String FIO;

    @Column(name = "predmet")
    private String predmet;

    @Column(name = "kol_vo_par")
    private Integer kol_vo_par;

    @Column(name = "stud")
    private Integer stud;

    @OneToOne(mappedBy = "prepod", cascade = CascadeType.ALL)
    private Predmet PrepodPredmet;

}
