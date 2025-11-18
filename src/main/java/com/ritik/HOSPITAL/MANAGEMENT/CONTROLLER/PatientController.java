package com.ritik.HOSPITAL.MANAGEMENT.CONTROLLER;

import com.ritik.HOSPITAL.MANAGEMENT.DTO.AppointmentResponseDto;
import com.ritik.HOSPITAL.MANAGEMENT.DTO.CreateAppointmentRequestDto;
import com.ritik.HOSPITAL.MANAGEMENT.DTO.PatientResponseDto;
import com.ritik.HOSPITAL.MANAGEMENT.SERVICE.AppointmentService;
import com.ritik.HOSPITAL.MANAGEMENT.SERVICE.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;
    private  final AppointmentService appointmentService;
 @PostMapping("/appointments")
    public ResponseEntity<AppointmentResponseDto> createNewAppointment(@RequestBody CreateAppointmentRequestDto createAppointmentRequestDto){
        return ResponseEntity.status(HttpStatus.CREATED).body((AppointmentResponseDto) appointmentService.createNewAppointment(createAppointmentRequestDto));
    }

    @GetMapping("/profile")
    private ResponseEntity<PatientResponseDto> getPatientProfile(){
     Long patientId =4L;
     return ResponseEntity.ok(patientService.getPatientById(patientId));
    }

}
