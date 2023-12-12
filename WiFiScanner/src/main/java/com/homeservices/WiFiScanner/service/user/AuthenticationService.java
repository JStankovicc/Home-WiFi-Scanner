package com.homeservices.WiFiScanner.service.user;

import com.homeservices.WiFiScanner.model.dto.JwtAuthenticationResponse;
import com.homeservices.WiFiScanner.model.dto.SignUpRequest;
import com.homeservices.WiFiScanner.model.dto.SigninRequest;

public interface AuthenticationService {
    JwtAuthenticationResponse signup(SignUpRequest request);

    JwtAuthenticationResponse signin(SigninRequest request);
}