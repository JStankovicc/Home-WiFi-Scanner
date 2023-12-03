package com.homeservices.WiFiScanner.service;

import com.homeservices.WiFiScanner.model.ARPContainer;
import com.homeservices.WiFiScanner.model.NetworkUser;
import com.homeservices.WiFiScanner.model.dto.NetworkUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.List;

@Service
public class ARPService {

    @Autowired
    private PINGService pingService;

    @Autowired
    private NetworkUserService networkUserService;


    public List<NetworkUserDto> getAllUsers(){
        List<ARPContainer> arpScan = scan();
        List<NetworkUserDto> users = getUsers(arpScan);
        return users;
    }


    public List<NetworkUserDto> getUsers(List<ARPContainer> list){
        List<NetworkUserDto> users = new ArrayList<>();

        for(ARPContainer arpContainer : list){
            NetworkUser networkUser = networkUserService.findOrCreate(arpContainer);

            NetworkUserDto networkUserDto = new NetworkUserDto(networkUser.getName(), arpContainer.getIp(), networkUser.getMacAddress());

            users.add(networkUserDto);
        }

        return users;
    }


    public List<ARPContainer> scan() {
        pingService.scan();
        List<ARPContainer> arpList = new ArrayList<>();
        try {
            Thread.sleep(1200);

            Process process = Runtime.getRuntime().exec("arp -a");
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Interface") || line.trim().isEmpty()) {
                    continue;
                }

                String[] parts = line.split("\\s+");
                if (parts.length >= 3 && parts[3].equals("dynamic")) {
                    arpList.add(new ARPContainer(parts[1],parts[2]));
                }
            }

            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return arpList;
    }

}
