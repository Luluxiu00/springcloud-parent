package com.olmysoft;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ErucekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ErucekaApplication.class, args);
	}
}
