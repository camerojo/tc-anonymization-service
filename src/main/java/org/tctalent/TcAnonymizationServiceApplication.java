package org.tctalent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.tctalent.anonymization.service.PopulateDatabaseService;

@SpringBootApplication
@EnableScheduling
public class TcAnonymizationServiceApplication implements CommandLineRunner {

    @Autowired
    PopulateDatabaseService populateDatabaseService;

    public static void main(String[] args) {
        SpringApplication.run(TcAnonymizationServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        populateDatabaseService.populateDatabase(50);
    }
}
