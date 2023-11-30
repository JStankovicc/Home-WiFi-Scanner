package com.homeservices.WiFiScanner.thread;

import com.homeservices.WiFiScanner.PingUtil;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class CheckPINGThread extends Thread{

    private int id;

    public CheckPINGThread(final int id){
        this.id = id;
    }

    @Override
    public void run(){
        String ipAddress = "192.168.1." + id;
        try {
            InetAddress inet = InetAddress.getByName(ipAddress);

            if (inet.isReachable(1000)) {
                PingUtil.pingResponseMap.put(id,true);
            }

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
