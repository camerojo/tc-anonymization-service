package org.tctalent.anonymization;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TcAnonymizationServiceApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(TcAnonymizationServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //TODO JC Trigger login to server (need app login - ie no MFA)
        //TODO JC Trigger query of all candidates
    }
}
