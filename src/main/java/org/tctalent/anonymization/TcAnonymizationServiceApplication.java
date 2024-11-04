package org.tctalent.anonymization;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.tctalent.anonymization.service.TalentCatalogService;

@SpringBootApplication
public class TcAnonymizationServiceApplication implements CommandLineRunner {
    private final TalentCatalogService talentCatalogService;

    public TcAnonymizationServiceApplication(TalentCatalogService talentCatalogService) {
        this.talentCatalogService = talentCatalogService;
    }

    public static void main(String[] args) {
        SpringApplication.run(TcAnonymizationServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        final String s = talentCatalogService.fetchPageOfCandidateDataAsJson(0);
//        System.out.println(s);
        //TODO JC Trigger login to server (need app login - ie no MFA)
        //TODO JC Trigger query of all candidates
    }
}
