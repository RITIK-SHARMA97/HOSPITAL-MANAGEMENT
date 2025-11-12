package com.ritik.HOSPITAL.MANAGEMENT;


import com.ritik.HOSPITAL.MANAGEMENT.ENTITY.Appointment;
import com.ritik.HOSPITAL.MANAGEMENT.ENTITY.Insurance;
import com.ritik.HOSPITAL.MANAGEMENT.ENTITY.Patient;
import com.ritik.HOSPITAL.MANAGEMENT.SERVICE.AppointmentService;
import com.ritik.HOSPITAL.MANAGEMENT.SERVICE.InsuranceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest
public class InsuranceTests {

    @Autowired
    private InsuranceService insuranceService;
    @Autowired
    private AppointmentService appointmentService;

    @Test
    public void testInsurance(){
        Insurance insurance = Insurance.builder()
                .policyNumber("HDFC_1234")
                .provider("HDFC")
                .validUntil(LocalDate.of(2018,12,12))
                .build();

      Patient patient=  insuranceService.assignInsuranceToPatient(insurance,1L);

        System.out.println(patient);
      var newPatient=  insuranceService.disaccociateInsuranceFromPatient(patient.getId());
        System.out.println(newPatient);
    }
    @Test
    public void testCreateAppointment(){
        Appointment appointment =Appointment.builder()
                .appointmentTime(LocalDateTime.of(2025,2,11,14,20,00))
                .reason("cough")
                .build();
        var newAppointment = appointmentService.createNewAppointment(appointment,1L,2L);
        System.out.println(newAppointment);

       var updatedAppointment = appointmentService.reAssignAppointmentToAnotherDoctor(newAppointment.getId(),3L);
        System.out.println(updatedAppointment);

    }
}
