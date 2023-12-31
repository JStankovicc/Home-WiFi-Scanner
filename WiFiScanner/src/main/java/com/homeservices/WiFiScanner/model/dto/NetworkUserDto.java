package com.homeservices.WiFiScanner.model.dto;

public class NetworkUserDto {

    private String name;
    private String ip;
    private String mac;

    public NetworkUserDto(String name, String ip, String mac) {
        this.name = name;
        this.ip = ip;
        this.mac = mac;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }
}
