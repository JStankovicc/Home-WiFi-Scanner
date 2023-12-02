package com.homeservices.WiFiScanner.controller;

import com.homeservices.WiFiScanner.service.PINGService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ping")
public class PINGController {

    @Autowired
    private PINGService pingService;

    @GetMapping("/getAll")
    public void getAll(){
        pingService.scan();
    }
}
