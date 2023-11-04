package com.jfnc.msventa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MsVentaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsVentaApplication.class, args);
	}

}
