package com.homeservices.WiFiScanner.service;

import com.homeservices.WiFiScanner.repository.NetworkUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NetworkUserService {

    @Autowired
    NetworkUserRepository networkUserRepository;

}
