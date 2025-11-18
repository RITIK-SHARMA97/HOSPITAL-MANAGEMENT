package com.ritik.HOSPITAL.MANAGEMENT.SECURITY;
import com.ritik.HOSPITAL.MANAGEMENT.DTO.SignUpResponseDto;
import com.ritik.HOSPITAL.MANAGEMENT.ENTITY.User;
import com.ritik.HOSPITAL.MANAGEMENT.CONTROLLER.AuthController;
import com.ritik.HOSPITAL.MANAGEMENT.DTO.LoginRequestDto;
import com.ritik.HOSPITAL.MANAGEMENT.DTO.LoginResponseDto;
import com.ritik.HOSPITAL.MANAGEMENT.REPOSITORY.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthenticationManager authenticationManager;

    private final AuthUtil authUtil;

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public LoginResponseDto login(LoginRequestDto loginRequestDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequestDto.getUsername(), loginRequestDto.getPassword())
        );

        User user = (User) authentication.getPrincipal();
        String token = authUtil.generateAccessToken(user);

        return new LoginResponseDto(token, user.getId());

    }

    public SignUpResponseDto signup(LoginRequestDto signupRequestDto) {
        User user = (User) userRepository.findByUsername(signupRequestDto.getUsername())
                .orElse(null);

        if (user != null) throw new IllegalArgumentException("User already exists");

        user = userRepository.save(User.builder()
                .username(signupRequestDto.getUsername())
                .password(passwordEncoder.encode(signupRequestDto.getPassword()))
                .build()
                    );
           return new SignUpResponseDto(user.getId(), user.getUsername());
    }
}
