package com.homeservices.WiFiScanner.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class NetworkUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String MACAddress;

    private String ipAddress;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public NetworkUser(){}

    public NetworkUser(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public NetworkUser(String MACAddress, String ipAddress){
        this.MACAddress = MACAddress;
        this.ipAddress = ipAddress;
    }

    public NetworkUser(String name, String MACAddress, String ipAddress) {
        this.name = name;
        this.MACAddress = MACAddress;
        this.ipAddress = ipAddress;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMACAddress() {
        return MACAddress;
    }

    public void setMACAddress(String MACAddress) {
        this.MACAddress = MACAddress;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
