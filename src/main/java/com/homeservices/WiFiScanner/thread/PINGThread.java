package com.homeservices.WiFiScanner.thread;

import com.homeservices.WiFiScanner.PingUtil;

public class PINGThread extends Thread{

    public PINGThread(){}

    @Override
    public void run(){
        for(int i = 1; i < 256; i++){
            PingUtil.pingResponseMap.put(i,false);
            CheckPINGThread thread = new CheckPINGThread(i);
            thread.start();
        }
    }

}
