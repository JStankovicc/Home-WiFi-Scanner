package com.homeservices.WiFiScanner.service;

import com.homeservices.WiFiScanner.model.User;
import com.homeservices.WiFiScanner.model.dto.AuthRequestDto;
import com.homeservices.WiFiScanner.model.dto.AuthResponseDto;
import com.homeservices.WiFiScanner.repository.UserRepository;
import com.homeservices.WiFiScanner.util.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthResponseDto signin(AuthRequestDto request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        User user = (User) userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password"));
        String jwt = jwtService.generateToken((UserDetails) user);
        System.out.println(jwt);
        return new AuthResponseDto(jwt);
    }
}