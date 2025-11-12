package com.ritik.HOSPITAL.MANAGEMENT.REPOSITORY;

import com.ritik.HOSPITAL.MANAGEMENT.ENTITY.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuranceRepository extends JpaRepository<Insurance, Long> {
}