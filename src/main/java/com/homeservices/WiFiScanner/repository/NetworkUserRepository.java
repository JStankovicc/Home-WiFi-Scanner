package com.homeservices.WiFiScanner.repository;

import com.homeservices.WiFiScanner.model.NetworkUser;
import com.homeservices.WiFiScanner.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NetworkUserRepository extends JpaRepository<NetworkUser, Integer> {
    Optional<NetworkUser> findByMACAddress(String MACAddress);

    List<NetworkUser> findByIpAddress(String ip);
}
