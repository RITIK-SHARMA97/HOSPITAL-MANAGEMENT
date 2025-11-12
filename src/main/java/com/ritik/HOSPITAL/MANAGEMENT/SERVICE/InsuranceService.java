package com.ritik.HOSPITAL.MANAGEMENT.SERVICE;


import com.ritik.HOSPITAL.MANAGEMENT.ENTITY.Appointment;
import com.ritik.HOSPITAL.MANAGEMENT.ENTITY.Doctor;
import com.ritik.HOSPITAL.MANAGEMENT.ENTITY.Insurance;
import com.ritik.HOSPITAL.MANAGEMENT.ENTITY.Patient;
import com.ritik.HOSPITAL.MANAGEMENT.REPOSITORY.AppointmentRepository;
import com.ritik.HOSPITAL.MANAGEMENT.REPOSITORY.DoctorRepository;
import com.ritik.HOSPITAL.MANAGEMENT.REPOSITORY.InsuranceRepository;
import com.ritik.HOSPITAL.MANAGEMENT.REPOSITORY.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsuranceService {
    private final InsuranceRepository insuranceRepository;
    private final PatientRepository patientRepository;
    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;


    @Transactional
    public Patient assignInsuranceToPatient(Insurance insurance ,Long patientId){


        Patient patient = patientRepository.findById(patientId).orElseThrow(() -> new EntityNotFoundException("Patient not found with id :" +patientId));

        patient.setInsurance(insurance);
        insurance.setPatient(patient);

        return patient;

    }
@Transactional
    public Patient disaccociateInsuranceFromPatient(Long patientId){
        Patient patient = patientRepository.findById(patientId).orElseThrow(() -> new EntityNotFoundException("Patient not found with id :" +patientId));

        patient.setInsurance(null);
        return  patient;
    }

}
