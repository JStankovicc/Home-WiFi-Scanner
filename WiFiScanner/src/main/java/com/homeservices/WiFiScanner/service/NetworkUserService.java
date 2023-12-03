package com.homeservices.WiFiScanner.service;

import com.homeservices.WiFiScanner.model.ARPContainer;
import com.homeservices.WiFiScanner.model.NetworkUser;
import com.homeservices.WiFiScanner.repository.NetworkUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NetworkUserService {

    @Autowired
    NetworkUserRepository networkUserRepository;

    public NetworkUser findOrCreate(ARPContainer arpContainer) {
        NetworkUser existingUser = networkUserRepository.findByMacAddress(arpContainer.getMac());

        if (existingUser != null) {
            return existingUser;
        } else {
            NetworkUser newUser = new NetworkUser();
            newUser.setMacAddress(arpContainer.getMac());

            return networkUserRepository.save(newUser);
        }
    }
}
