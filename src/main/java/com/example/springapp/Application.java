package com.example.springapp;

import com.example.springapp.run.H2RunRepository;
import com.example.springapp.run.Location;
import com.example.springapp.run.Run;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@SpringBootApplication
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
        log.info("Application started successfully");
    }


    @Bean
    CommandLineRunner runner(H2RunRepository runRepository) {
        return args -> {
            Run run = new Run(1, "first run",
                    LocalDateTime.now(),
                    LocalDateTime.now().plus(1, ChronoUnit.HOURS),
                    4.5,
                    Location.OUTDOOR);
            runRepository.create(run);
            log.info("Run - " + run);
        };
    }

}

