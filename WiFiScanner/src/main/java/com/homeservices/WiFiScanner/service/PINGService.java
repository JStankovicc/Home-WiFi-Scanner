package com.homeservices.WiFiScanner.service;

import com.homeservices.WiFiScanner.thread.PINGThread;
import org.springframework.stereotype.Service;

@Service
public class PINGService {

    public void scan() {
        for(int i = 2; i < 255; i++){
            PINGThread pingThread = new PINGThread(i);
            pingThread.start();
        }
    }
}
