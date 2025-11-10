package com.ritik.HOSPITAL.MANAGEMENT.DTO;

import com.ritik.HOSPITAL.MANAGEMENT.ENTITY.TYPE.BloodGroupType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class BloodGroupCountResponseEntity {

    private BloodGroupType bloodGroupType;
    private Long court;


}
