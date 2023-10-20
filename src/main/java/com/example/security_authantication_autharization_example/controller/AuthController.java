package com.example.security_authantication_autharization_example.controller;

import com.example.security_authantication_autharization_example.dto.request.AuthenticationRequest;
import com.example.security_authantication_autharization_example.dto.request.RegisterRequest;
import com.example.security_authantication_autharization_example.dto.response.AuthenticationResponse;
import com.example.security_authantication_autharization_example.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest request) {

        return authenticationService.register(request);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody AuthenticationRequest request) {

        return ResponseEntity.ok(authenticationService.authenticate(request));
    }

    @PreAuthorize("hasAuthority('ADMIN') || hasAuthority('USER')")
    @GetMapping("/user")
    public ResponseEntity<String> getUser() {

        return ResponseEntity.ok("deneme");
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/admin")
    public ResponseEntity<String> getAdmin() {

        return ResponseEntity.ok("Sadece Admin görebilir");
    }
}
