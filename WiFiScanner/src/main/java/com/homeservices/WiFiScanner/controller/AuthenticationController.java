package com.homeservices.WiFiScanner.controller;

import com.homeservices.WiFiScanner.model.dto.JwtAuthenticationResponse;
import com.homeservices.WiFiScanner.model.dto.SignUpRequest;
import com.homeservices.WiFiScanner.model.dto.SigninRequest;
import com.homeservices.WiFiScanner.service.user.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    @PostMapping("/signup")
    public ResponseEntity<JwtAuthenticationResponse> signup(@RequestBody SignUpRequest request) {
        return ResponseEntity.ok(authenticationService.signup(request));
    }

    @PostMapping("/signin")
    public ResponseEntity<JwtAuthenticationResponse> signin(@RequestBody SigninRequest request) {
        return ResponseEntity.ok(authenticationService.signin(request));
    }
}