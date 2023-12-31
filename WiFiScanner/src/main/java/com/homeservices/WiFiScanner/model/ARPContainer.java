package com.homeservices.WiFiScanner.model;

public class ARPContainer {

    private String ip;
    private String mac;

    public ARPContainer(String ip, String mac){
        this.ip = ip;
        this.mac = mac;
    }

    public void printInfo(){
        System.out.println("IP: " + this.ip + "  MAC:  " + this.mac);
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
