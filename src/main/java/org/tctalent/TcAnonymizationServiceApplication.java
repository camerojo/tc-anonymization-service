package org.tctalent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.tctalent.anonymization.service.PopulateDatabaseService;
import org.tctalent.anonymization.service.TalentCatalogService;

@SpringBootApplication
@EnableScheduling
public class TcAnonymizationServiceApplication implements CommandLineRunner {

    @Autowired
    PopulateDatabaseService populateDatabaseService;

    @Autowired
    TalentCatalogService talentCatalogService;

    public static void main(String[] args) {
        SpringApplication.run(TcAnonymizationServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        final String s = talentCatalogService.fetchPageOfCandidateDataAsJson(0);
//        System.out.println(s);
        //TODO JC Trigger login to server (need app login - ie no MFA)
        //TODO JC Trigger query of all candidates
        talentCatalogService.login();

        populateDatabaseService.populateDatabase(50);

    }
}
