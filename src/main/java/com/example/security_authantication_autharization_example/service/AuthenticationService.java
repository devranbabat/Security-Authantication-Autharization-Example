package com.example.security_authantication_autharization_example.service;


import com.example.security_authantication_autharization_example.auth.JwtService;
import com.example.security_authantication_autharization_example.dto.request.AuthenticationRequest;
import com.example.security_authantication_autharization_example.dto.request.RegisterRequest;
import com.example.security_authantication_autharization_example.dto.response.AuthenticationResponse;
import com.example.security_authantication_autharization_example.entity.Role;
import com.example.security_authantication_autharization_example.entity.User;
import com.example.security_authantication_autharization_example.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    public ResponseEntity<String> register(RegisterRequest request) {

        final var user = new User(null,
                request.getFirstname(),
                request.getLastname(),
                request.getEmail(),
                passwordEncoder.encode(request.getPassword()),
                Role.USER);

        userRepository.save(user);

        return ResponseEntity.ok("Kaydedildi");
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        final var user = userRepository.findByEmail(request.getEmail());

        final var token = JwtService.generateToken(user);

        return new AuthenticationResponse(token);

    }
}
