package com.homeservices.WiFiScanner.repository;

import com.homeservices.WiFiScanner.model.NetworkUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface NetworkUserRepository extends JpaRepository<NetworkUser, Long> {
    NetworkUser findByMacAddress(String macAddress);

    @Modifying
    @Query("UPDATE NetworkUser u SET u.name = :name WHERE u.macAddress = :mac")
    void changeNameByMac(String name, String mac);
}
