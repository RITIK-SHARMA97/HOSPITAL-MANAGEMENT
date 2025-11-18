package com.ritik.HOSPITAL.MANAGEMENT.ENTITY;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

    @OneToOne
    @JoinColumn(name ="user_id",nullable = false)
    private User user;

    @Column(nullable = false,length=100)
    private String name;

    @Column(length = 100)
    private String specialization ;

    @Column(nullable = false,unique = true, length = 100)
    private String email;

    @ManyToMany(mappedBy = "doctor")
    private Set<Department> departments = new HashSet<>();

    @OneToMany(mappedBy = "doctor")
    private List<Appointment> appointments = new ArrayList<>();


}
