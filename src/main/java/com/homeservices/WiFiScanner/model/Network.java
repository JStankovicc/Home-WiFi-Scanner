package com.homeservices.WiFiScanner.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.lang.NonNull;

import java.time.LocalDateTime;

@Entity
public class Network {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NonNull
    private String ipAddress;

    @NonNull
    private LocalDateTime createdAt;

    @NonNull
    public String getIpAddress() {
        return ipAddress;
    }


    public Network(){}

    public Network(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public void setIpAddress(@NonNull String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(@NonNull LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
