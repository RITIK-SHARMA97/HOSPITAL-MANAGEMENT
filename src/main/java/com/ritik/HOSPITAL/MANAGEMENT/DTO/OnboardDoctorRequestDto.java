package com.ritik.HOSPITAL.MANAGEMENT.DTO;

import lombok.Data;

@Data
public class OnboardDoctorRequestDto {
    private Long userId;
    private String specialization;
    private String name;
}
