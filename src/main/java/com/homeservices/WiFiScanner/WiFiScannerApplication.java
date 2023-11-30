package com.homeservices.WiFiScanner;

import com.homeservices.WiFiScanner.service.CheckPINGService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.homeservices.WiFiScanner.service")
public class WiFiScannerApplication {

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(WiFiScannerApplication.class, args);
	}

}
