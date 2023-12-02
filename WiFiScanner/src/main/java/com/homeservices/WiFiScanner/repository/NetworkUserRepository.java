package com.homeservices.WiFiScanner.repository;

import com.homeservices.WiFiScanner.model.NetworkUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NetworkUserRepository extends JpaRepository<NetworkUser, Long> {
}
