package com.ritik.HOSPITAL.MANAGEMENT;

import com.ritik.HOSPITAL.MANAGEMENT.DTO.BloodGroupCountResponseEntity;
import com.ritik.HOSPITAL.MANAGEMENT.ENTITY.Patient;
import com.ritik.HOSPITAL.MANAGEMENT.ENTITY.TYPE.BloodGroupType;
import com.ritik.HOSPITAL.MANAGEMENT.REPOSITORY.PatientRepository;
import com.ritik.HOSPITAL.MANAGEMENT.SERVICE.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
public class PatientTests {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientService patientService;

    @Test
     public void testPatientRepository(){
       List<Patient> patientList= patientRepository.findAllPatientWithAppointment();
        System.out.println(patientList);

//        Patient p1 = new Patient();
//        patientRepository.save(p1);

    }

    @Test

    public void testTransactionMethods(){
//        Patient patient =patientService.getPatientById(1L);
//        System.out.println(patient);

//        List<Patient> patientList =patientRepository.findByBirthDateOrEmail(LocalDate.of(2004,05,04),"hey@gmail.com");

//        Patient patient= patientRepository.findByName("hello");

//        List<Patient> patientList =patientRepository.findByBornAfterDate(LocalDate.of(1993,3,14));

       Page<Patient> patientList = patientRepository.findAllPatients(PageRequest.of(0,2, Sort.by("name")));

        for (Patient patient : patientList) {
            System.out.println(patient);
        }
//        List<Object[]> bloodGroupList = patientRepository.countEachBloodGroupType();
//        for(Object[] objects: bloodGroupList){
//            System.out.println(objects[0] + " " + objects[1]);
//        }
//        int rowUpdated = patientRepository.updateNameWithId("Ritik Sharma", 1L);
//        System.out.println(rowUpdated);


//        List<BloodGroupCountResponseEntity> bloodGroupList = patientRepository.countEachBloodGroupType();
//        for(BloodGroupCountResponseEntity bloodGroupCountResponseEntity: bloodGroupList){
//            System.out.println(bloodGroupCountResponseEntity);
//        }
    }

}
