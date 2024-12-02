package org.tctalent.anonymization.bootstrap;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.List;
import org.tctalent.anonymization.entity.CandidateEntity;
import org.tctalent.anonymization.repository.CandidateRepository;

@Component
@Slf4j
public class CandidateBootstrap implements CommandLineRunner {

  private final CandidateRepository candidateRepository;

  public CandidateBootstrap(CandidateRepository candidateRepository) {
    this.candidateRepository = candidateRepository;
  }

  @Override
  public void run(String... args) throws Exception {
    // Clear existing data
    candidateRepository.deleteAll();

    // Create sample candidates
    CandidateEntity candidate1 = new CandidateEntity();
    candidate1.setCandidateNumber("CAND-001");
    candidate1.setStatus("active");
    candidate1.setGender("Female");
    candidate1.setCountryId(101L);
    candidate1.setCity("Springfield");
    candidate1.setYearOfArrival(2010);
    candidate1.setCreatedDate(OffsetDateTime.now());
    candidate1.setUpdatedDate(OffsetDateTime.now());

    CandidateEntity candidate2 = new CandidateEntity();
    candidate2.setCandidateNumber("CAND-002");
    candidate2.setStatus("pending");
    candidate2.setGender("Male");
    candidate2.setCountryId(202L);
    candidate2.setCity("Shelbyville");
    candidate2.setYearOfArrival(2015);
    candidate2.setCreatedDate(OffsetDateTime.now());
    candidate2.setUpdatedDate(OffsetDateTime.now());

    CandidateEntity candidate3 = new CandidateEntity();
    candidate3.setCandidateNumber("CAND-003");
    candidate3.setStatus("inactive");
    candidate3.setGender("Other");
    candidate3.setCountryId(303L);
    candidate3.setCity("Capital City");
    candidate3.setYearOfArrival(2018);
    candidate3.setCreatedDate(OffsetDateTime.now());
    candidate3.setUpdatedDate(OffsetDateTime.now());

    // Save to database
    candidateRepository.saveAll(List.of(candidate1, candidate2, candidate3));

    // Print confirmation
    log.info("Sample candidates have been saved to the database.");
  }
}
