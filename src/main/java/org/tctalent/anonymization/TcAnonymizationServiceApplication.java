package org.tctalent.anonymization;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TcAnonymizationServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TcAnonymizationServiceApplication.class, args);

        //TODO JC Trigger login to server
        //TODO JC Trigger query of all candidates
    }

}
