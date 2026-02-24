package com.Metron.DetectionAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class DetectionApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DetectionApiApplication.class, args);
	}

}
