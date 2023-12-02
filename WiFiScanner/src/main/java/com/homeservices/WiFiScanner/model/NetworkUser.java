package com.homeservices.WiFiScanner.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class NetworkUser {
    @Id
    private Long id;

    private String name;

    private String macAddress;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }
}
