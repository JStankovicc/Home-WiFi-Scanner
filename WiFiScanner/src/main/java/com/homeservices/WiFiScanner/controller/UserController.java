package com.homeservices.WiFiScanner.controller;

import com.homeservices.WiFiScanner.model.dto.AuthRequestDto;
import com.homeservices.WiFiScanner.model.dto.AuthResponseDto;
import com.homeservices.WiFiScanner.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDto> login(@RequestBody AuthRequestDto request) {
        System.out.println(request.getUsername() + "  " + request.getPassword());
        return ResponseEntity.ok(authenticationService.signin(request));
    }
}