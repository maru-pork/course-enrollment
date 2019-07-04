package com.sample.microserviceusermanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MicroserviceUserManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceUserManagementApplication.class, args);
	}

}
