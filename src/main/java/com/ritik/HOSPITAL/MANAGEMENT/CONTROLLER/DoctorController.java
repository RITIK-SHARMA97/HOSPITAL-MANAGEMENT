package com.ritik.HOSPITAL.MANAGEMENT.CONTROLLER;

import com.ritik.HOSPITAL.MANAGEMENT.DTO.AppointmentResponseDto;
import com.ritik.HOSPITAL.MANAGEMENT.SERVICE.AppointmentService;
import lombok.RequiredArgsConstructor;
import com.ritik.HOSPITAL.MANAGEMENT.ENTITY.User;  // ✔ CORRECT
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/doctors")
@RequiredArgsConstructor
public class DoctorController {
    private final AppointmentService appointmentService;


    @GetMapping("/appointments")
    public ResponseEntity<List<AppointmentResponseDto>> getAllAppointmentsOfDoctor() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return ResponseEntity.ok(appointmentService.getAllAppointmentsOfDoctor(user.getId()));
    }
}
