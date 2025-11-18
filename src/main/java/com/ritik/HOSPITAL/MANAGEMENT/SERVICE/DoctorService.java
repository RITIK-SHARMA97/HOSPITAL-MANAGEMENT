package com.ritik.HOSPITAL.MANAGEMENT.SERVICE;
import com.ritik.HOSPITAL.MANAGEMENT.DTO.OnboardDoctorRequestDto;
import com.ritik.HOSPITAL.MANAGEMENT.ENTITY.Doctor;
import com.ritik.HOSPITAL.MANAGEMENT.REPOSITORY.UserRepository;
import jakarta.transaction.Transactional;
import com.ritik.HOSPITAL.MANAGEMENT.ENTITY.User;  // ✔ CORRECT
import org.modelmapper.ModelMapper;
import com.ritik.HOSPITAL.MANAGEMENT.DTO.DoctorResponseDto;
import com.ritik.HOSPITAL.MANAGEMENT.REPOSITORY.DoctorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class DoctorService {


    private final DoctorRepository doctorRepository;
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    public List<DoctorResponseDto> getAllDoctor(){

        return doctorRepository.findAll()
                .stream()
                .map(doctor -> modelMapper.map(doctor, DoctorResponseDto.class))
                .collect(Collectors.toList());
    }
    @Transactional
    public DoctorResponseDto onBoardNewDoctor(OnboardDoctorRequestDto onBoardDoctorRequestDto) {
        User user = userRepository.findById(onBoardDoctorRequestDto.getUserId()).orElseThrow();

        if(doctorRepository.existsById(onBoardDoctorRequestDto.getUserId())) {
            throw new IllegalArgumentException("Already a doctor");
        }

        Doctor doctor = Doctor.builder()
                .name(onBoardDoctorRequestDto.getName())
                .specialization(onBoardDoctorRequestDto.getSpecialization())
                .user(user)
                .build();

//        user.getRoles().add(RoleType.DOCTOR);

        return modelMapper.map(doctorRepository.save(doctor), DoctorResponseDto.class);
    }
}
