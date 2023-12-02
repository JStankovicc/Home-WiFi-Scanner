package com.homeservices.WiFiScanner.thread;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class PINGThread extends Thread{

    private int id;

    public PINGThread(final int id){
        this.id = id;
    }

    @Override
    public void run(){
        String ipAddress = "192.168.1." + id;
        try {
            InetAddress inetAddress = InetAddress.getByName(ipAddress);
            if (inetAddress.isReachable(1000)) {
                System.out.println(ipAddress + " je tu");
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
