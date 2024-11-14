package org.tctalent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.tctalent.anonymization.service.PopulateDatabaseService;

/**
 * This is a minimal Spring Command Line Runner which populates database to local MongoDB on start
 * up.
 * <p/>
 * It connects to a locally running TC server using hard coded params - see TalentCatalogServiceImpl.
 * It operates by running the search with the (currently hard coded) search id and then loading data
 * a page at a time. That data is saved into a local MongoDB installed using all defaults:
 * - Database name test
 * - No user or password
 * - mongodb://localhost:27017/test
 * <p/>
 *  See
 *  <a href="https://www.mongodb.com/docs/manual/tutorial/install-mongodb-on-os-x/">
 *    Installing MongoDB on Mac</a>
 */
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
