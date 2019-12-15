package org.doublem.dailyreports;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableFeignClients
@ComponentScan({
        "org.doublem.dailyreports.client",
        "org.doublem.dailyreports.config",
        "org.doublem.dailyreports.controller",
        "org.doublem.dailyreports.service"
})
public class DailyReportsApplication {

    public static void main(String[] args) {
        SpringApplication.run(DailyReportsApplication.class, args);
    }

}