package com.homeservices.WiFiScanner.service;

import com.homeservices.WiFiScanner.PingUtil;
import com.homeservices.WiFiScanner.model.NetworkUser;
import com.homeservices.WiFiScanner.thread.PINGThread;
import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CheckPINGService {

    @Autowired
    private NetworkUserService networkUserService;

    public void checkByPING() throws InterruptedException {
        PINGThread pingThread = new PINGThread();
        pingThread.start();
        pingThread.join();
    }

    public void updateDatabase(){
        for(int i = 1; i < 256; i++){
            String ip = "192.168.1." + i;
            NetworkUser networkUser = networkUserService.getNetworkUserByIP(ip);
            if(networkUser != null){
                //Check for MAC address...  Better use ARP
            }else {
                networkUserService.addNewUserByIp(ip);
            }
        }
    }

    public List<NetworkUser> getNetworkUsers(){
        List<NetworkUser> users = new ArrayList<>();

        for(int i = 1; i < 256; i++){
            String ip = "192.168.1." + PingUtil.pingResponseMap.get(i);
            NetworkUser networkUser = networkUserService.getNetworkUserByIP(ip);
            if (networkUser != null){
                users.add(networkUser);
            }else {
                networkUserService.addNewUserByIp(ip);
                users.add(networkUser);
            }
        }

        for(NetworkUser u : users){
            System.out.println(u.getIpAddress());
        }


        return users;
    }

}
