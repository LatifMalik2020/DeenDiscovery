package com.provisionTechAdvisors.DeenDiscovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.provisionTechAdvisors.DeenDiscovery")
public class DeenDiscoveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeenDiscoveryApplication.class, args);
	}

}
