package com.ritik.HOSPITAL.MANAGEMENT.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignUpRequestDto {
    private String userId;
    private String password;
    private String name;
//    private Set<RoleType> roles = new HashSet<>();
}
