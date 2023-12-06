package com.homeservices.WiFiScanner.service;

import com.homeservices.WiFiScanner.model.ARPContainer;
import com.homeservices.WiFiScanner.model.NetworkUser;
import com.homeservices.WiFiScanner.model.dto.NetworkUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.List;

@Service
public class ARPService {

    @Autowired
    private PINGService pingService;

    @Autowired
    private NetworkUserService networkUserService;

    private static final int SLEEP_DURATION_PING = 2000;
    private static final int SLEEP_DURATION_CLEAR = 1000;


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

        clearArpTable();

        List<ARPContainer> arpList = new ArrayList<>();

        try {
            Thread.sleep(SLEEP_DURATION_CLEAR);
            pingService.scan();
            Thread.sleep(SLEEP_DURATION_PING);

            Process process = Runtime.getRuntime().exec("arp -a");

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    if (shouldSkipLine(line)) {
                        continue;
                    }

                    String[] parts = line.split("\\s+");
                    if (isDynamic(parts)) {
                        arpList.add(new ARPContainer(parts[1], parts[2]));
                    }
                }
            }
            int exitCode = process.waitFor();
            if (exitCode != 0) {
                System.err.println("Neka greška se dogodila prilikom izvršavanja 'arp -a' komande. Kod izlaza: " + exitCode);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return arpList;
    }

    public void clearArpTable() {
        try {
            String os = System.getProperty("os.name").toLowerCase();

            if (os.contains("win")) {
                ProcessBuilder processBuilder = new ProcessBuilder("cmd", "/c", "arp -d");
                Process process = processBuilder.start();
                int exitCode = process.waitFor();
                if (exitCode != 0) {
                    System.err.println("Neka greška se dogodila prilikom izvršavanja 'arp -d'.");
                }
            } else if (os.contains("nix") || os.contains("nux") || os.contains("mac")) {
                ProcessBuilder processBuilder = new ProcessBuilder("sudo", "arp", "-d", "-a");
                Process process = processBuilder.start();
                int exitCode = process.waitFor();
                if (exitCode != 0) {
                    System.err.println("Neka greška se dogodila prilikom izvršavanja 'sudo arp -d -a'.");
                }
            } else {
                System.err.println("Operativni sistem nije podržan za brisanje ARP tabele.");
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private boolean shouldSkipLine(String line) {
        return line.startsWith("Interface") || line.trim().isEmpty();
    }

    private boolean isDynamic(String[] parts) {
        return parts.length >= 3 && "dynamic".equals(parts[3]);
    }
}