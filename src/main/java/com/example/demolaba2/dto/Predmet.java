package com.example.demolaba2.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "predmet")
public class Predmet {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prepod_seq")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "day_of_week")
    private String day_of_week;

    @Column(name = "number_class")
    private Integer number_class;

    @ToString.Exclude
    @OneToOne
    @JoinColumn(name = "prepod_id")
    public Prepod prepod;

}
