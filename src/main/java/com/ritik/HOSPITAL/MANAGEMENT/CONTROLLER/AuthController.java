package com.ritik.HOSPITAL.MANAGEMENT.CONTROLLER;


import com.ritik.HOSPITAL.MANAGEMENT.DTO.LoginRequestDto;
import com.ritik.HOSPITAL.MANAGEMENT.DTO.LoginResponseDto;
import com.ritik.HOSPITAL.MANAGEMENT.DTO.SignUpRequestDto;
import com.ritik.HOSPITAL.MANAGEMENT.DTO.SignUpResponseDto;
import com.ritik.HOSPITAL.MANAGEMENT.SECURITY.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private  final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto loginRequestDto){

        return ResponseEntity.ok(authService.login(loginRequestDto));

    }

    @PostMapping("/signup")
    public ResponseEntity<SignUpResponseDto> signup(@RequestBody LoginRequestDto signupRequestDto){

        return ResponseEntity.ok(authService.signup(signupRequestDto));

    }

}
