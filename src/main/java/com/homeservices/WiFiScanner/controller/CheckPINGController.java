package com.homeservices.WiFiScanner.controller;

import com.homeservices.WiFiScanner.service.CheckPINGService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/checkPing")
public class CheckPINGController {

    @GetMapping
    public void checkPing(){
        CheckPINGService service = new CheckPINGService();
        service.getNetworkUsers();
    }

}
