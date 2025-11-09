package com.ritik.HOSPITAL.MANAGEMENT;

import com.ritik.HOSPITAL.MANAGEMENT.ENTITY.Patient;
import com.ritik.HOSPITAL.MANAGEMENT.REPOSITORY.PatientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PatientTests {

    @Autowired
    private PatientRepository patientRepository;

    @Test
     public void testPatientRepository(){
       List<Patient> patientList= patientRepository.findAll();
        System.out.println(patientList);

    }

}
