package com.homeservices.WiFiScanner.controller;

import com.homeservices.WiFiScanner.service.ARPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/arp")
public class ARPController {

    @Autowired
    private ARPService arpService;

    @GetMapping("/getAll")
    public void getAll(){
        arpService.testMethod();
    }

}
