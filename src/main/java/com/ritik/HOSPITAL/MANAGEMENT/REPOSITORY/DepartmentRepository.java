package com.ritik.HOSPITAL.MANAGEMENT.REPOSITORY;

import com.ritik.HOSPITAL.MANAGEMENT.ENTITY.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}