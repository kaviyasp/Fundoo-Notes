package com.fundoonotes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;

@SpringBootApplication
@EnableCaching
@EnableJms
@EnableBatchProcessing

//Fundoo-Notes

public class FundooNotesApplication {
    public static void main(String[] args) {
        SpringApplication.run(FundooNotesApplication.class, args);
    }
}