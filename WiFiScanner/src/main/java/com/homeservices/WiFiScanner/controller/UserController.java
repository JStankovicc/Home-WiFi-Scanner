package com.homeservices.WiFiScanner.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login() {
        Map<String, String> response = new HashMap<>();
        String hardcodedJwt = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJrb3Jpc3VuaWQxMjMiLCJpYXQiOjE2MTAwMDAwMDAsImV4cCI6MTYxMDA5NjAwMH0.4KUXB2C5TBgEGdpfgBpJtsfKYXKF6LReV2ZYRmMKZvU";

        response.put("token", hardcodedJwt);
        return ResponseEntity.ok(response);
    }
}