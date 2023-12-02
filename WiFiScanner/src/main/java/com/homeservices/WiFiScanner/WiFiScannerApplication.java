package com.homeservices.WiFiScanner;

import com.homeservices.WiFiScanner.service.ARPService;
import com.homeservices.WiFiScanner.service.PINGService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WiFiScannerApplication {

	public static void main(String[] args) {
		SpringApplication.run(WiFiScannerApplication.class, args);

		/**ARPService arpService = new ARPService();
		arpService.scan();

		PINGService pingService = new PINGService();
		pingService.scan();*/
	}

}
