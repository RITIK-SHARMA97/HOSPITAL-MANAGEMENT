package com.ritik.HOSPITAL.MANAGEMENT.REPOSITORY;

import com.ritik.HOSPITAL.MANAGEMENT.ENTITY.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}