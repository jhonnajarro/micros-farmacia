package com.jfnc.mscompras;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MscomprasApplication {

	public static void main(String[] args) {
		SpringApplication.run(MscomprasApplication.class, args);
	}

}
