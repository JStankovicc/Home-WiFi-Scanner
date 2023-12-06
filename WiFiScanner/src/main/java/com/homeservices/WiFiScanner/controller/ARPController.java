package com.homeservices.WiFiScanner.controller;

import com.homeservices.WiFiScanner.model.dto.NetworkUserDto;
import com.homeservices.WiFiScanner.model.dto.NetworkUserRequestDto;
import com.homeservices.WiFiScanner.service.ARPService;
import com.homeservices.WiFiScanner.service.NetworkUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/arp")
@CrossOrigin
public class ARPController {

    @Autowired
    private ARPService arpService;

    @Autowired
    private NetworkUserService networkUserService;

    @GetMapping("/getAll")
    public ResponseEntity<List<NetworkUserDto>> getAll(){
        List<NetworkUserDto> aprResponse = arpService.getAllUsers();
        return ResponseEntity.ok(aprResponse);
    }

    @PostMapping("/rename")
    public ResponseEntity<?> renameNetworkUser(@RequestBody NetworkUserRequestDto networkUserDTO) {
        String name = networkUserDTO.getName();
        String mac = networkUserDTO.getMac();

        networkUserService.changeName(name,mac);

        return ResponseEntity.ok("Success");
    }
}
