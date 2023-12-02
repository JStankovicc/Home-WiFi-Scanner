package com.homeservices.WiFiScanner.model;

public class NetworkUserBuilder {
    private Long id;
    private String name;
    private String macAddress;

    public NetworkUserBuilder setId(Long id) {
        this.id = id;
        return this;
    }

    public NetworkUserBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public NetworkUserBuilder setMacAddress(String macAddress) {
        this.macAddress = macAddress;
        return this;
    }

    public NetworkUser build() {
        NetworkUser networkUser = new NetworkUser();
        networkUser.setId(this.id);
        networkUser.setName(this.name);
        networkUser.setMacAddress(this.macAddress);
        return networkUser;
    }
}