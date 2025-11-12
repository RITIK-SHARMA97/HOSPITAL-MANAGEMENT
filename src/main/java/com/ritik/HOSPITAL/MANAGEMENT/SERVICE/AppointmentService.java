package com.ritik.HOSPITAL.MANAGEMENT.SERVICE;

import com.ritik.HOSPITAL.MANAGEMENT.ENTITY.Appointment;
import com.ritik.HOSPITAL.MANAGEMENT.ENTITY.Doctor;
import com.ritik.HOSPITAL.MANAGEMENT.ENTITY.Patient;
import com.ritik.HOSPITAL.MANAGEMENT.REPOSITORY.AppointmentRepository;
import com.ritik.HOSPITAL.MANAGEMENT.REPOSITORY.DoctorRepository;
import com.ritik.HOSPITAL.MANAGEMENT.REPOSITORY.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;


    @Transactional
    public Appointment createNewAppointment(Appointment appointment,Long doctorId,Long patientId){

        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();
        Patient patient= patientRepository.findById(patientId).orElseThrow();

          if(appointment.getId() != null) throw new IllegalArgumentException("Appointment should have Id");

          appointment.setPatient(patient);
          appointment.setDoctor(doctor);

          patient.getAppointments().add(appointment);
//          appointmentRepository.save(appointment);

          return appointmentRepository.save(appointment);


    }
    @Transactional
    public Appointment reAssignAppointmentToAnotherDoctor(Long appointmentId, Long doctorId){
        Appointment appointment = appointmentRepository.findById(appointmentId).orElseThrow();
        Doctor doctor =doctorRepository.findById(doctorId).orElseThrow();

        appointment.setDoctor(doctor);
        doctor.getAppointments().add(appointment);
        return appointment;

    }
}
