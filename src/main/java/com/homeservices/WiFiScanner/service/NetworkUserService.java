package com.homeservices.WiFiScanner.service;

import com.homeservices.WiFiScanner.model.NetworkUser;
import com.homeservices.WiFiScanner.model.User;
import com.homeservices.WiFiScanner.repository.NetworkUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NetworkUserService {

    @Autowired
    private NetworkUserRepository networkUserRepository;

    public Optional<NetworkUser> getNetworkUserById(int id){
        return networkUserRepository.findById(id);
    }

    public Optional<NetworkUser> getNetworkUserByMAC(String MAC){
        return networkUserRepository.findByMACAddress(MAC);
    }

    public NetworkUser getNetworkUserByIP(String ip){
        List<NetworkUser> users = networkUserRepository.findByIpAddress(ip);
        if (users.isEmpty()) {
            return null;
        }
        users.sort((user1, user2) -> user2.getCreatedAt().compareTo(user1.getCreatedAt()));

        return users.get(0);
    }

    public void addNewUserByIp(String ip) {
        NetworkUser user = new NetworkUser(ip);
        networkUserRepository.save(user);
    }
}
