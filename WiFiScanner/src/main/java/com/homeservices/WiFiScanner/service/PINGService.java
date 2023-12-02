package com.homeservices.WiFiScanner.service;

import com.homeservices.WiFiScanner.thread.PINGThread;
import org.springframework.stereotype.Service;

@Service
public class PINGService {

    public void scan() {
        PINGThread[] threads = new PINGThread[254];
        for(int i = 2; i < 255; i++){
            PINGThread pingThread = new PINGThread(i);
            threads[i-2] = pingThread;
            pingThread.start();
        }

        for(PINGThread pingThread : threads){
            try {
                pingThread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
