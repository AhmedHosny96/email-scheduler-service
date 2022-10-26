package com.sahay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class EmailSchedulerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmailSchedulerServiceApplication.class, args);
    }

}
