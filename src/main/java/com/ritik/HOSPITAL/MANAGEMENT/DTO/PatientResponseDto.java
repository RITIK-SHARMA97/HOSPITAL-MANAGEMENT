package com.ritik.HOSPITAL.MANAGEMENT.DTO;

import com.ritik.HOSPITAL.MANAGEMENT.ENTITY.TYPE.BloodGroupType;
import lombok.Data;

@Data
public class PatientResponseDto {
    private Long id;
    private String name;
  private   String gender;
  private BloodGroupType bloodGroup;

}
