package org.doublem.dailyreports;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DailyReportsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DailyReportsApplication.class, args);
	}

}