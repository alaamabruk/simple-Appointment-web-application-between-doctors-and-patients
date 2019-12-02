package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@EnableEurekaServer
@SpringBootApplication
public class AppointementsAppConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppointementsAppConfigServerApplication.class, args);
	}

}
