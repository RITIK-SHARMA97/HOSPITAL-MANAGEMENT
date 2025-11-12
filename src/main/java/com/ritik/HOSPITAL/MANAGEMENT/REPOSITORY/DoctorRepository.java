package com.ritik.HOSPITAL.MANAGEMENT.REPOSITORY;

import com.ritik.HOSPITAL.MANAGEMENT.ENTITY.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}