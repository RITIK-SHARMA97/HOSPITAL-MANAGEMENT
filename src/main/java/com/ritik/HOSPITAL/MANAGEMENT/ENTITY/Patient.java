package com.ritik.HOSPITAL.MANAGEMENT.ENTITY;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.ToString;
import org.hibernate.tool.schema.spi.SchemaTruncator;

import java.time.LocalDate;

@Entity
@ToString
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long Id;

    private String name;

    private LocalDate birthdate;

    private String email;
 @ToString.Exclude
    private String gender;



}
