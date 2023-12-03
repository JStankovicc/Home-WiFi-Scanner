package com.homeservices.WiFiScanner.controller;

import com.homeservices.WiFiScanner.model.dto.NetworkUserDto;
import com.homeservices.WiFiScanner.service.ARPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/arp")
@CrossOrigin
public class ARPController {

    @Autowired
    private ARPService arpService;

    @GetMapping("/getAll")
    public ResponseEntity<List<NetworkUserDto>> getAll(){
        List<NetworkUserDto> aprResponse = arpService.getAllUsers();
        return ResponseEntity.ok(aprResponse);
    }
}
