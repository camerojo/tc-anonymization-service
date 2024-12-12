package org.tctalent.anonymization.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.List;
import java.util.concurrent.ScheduledFuture;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestClientException;
import org.tctalent.anonymization.entity.mongo.CandidateDocument;
import org.tctalent.anonymization.mapper.CandidateMapper;
import org.tctalent.anonymization.model.Candidate;
import org.tctalent.anonymization.model.CandidatePage;
import org.tctalent.anonymization.model.IdentifiableCandidate;
import org.tctalent.anonymization.model.IdentifiableCandidatePage;
import org.tctalent.anonymization.repository.CandidateMongoRepository;
import org.tctalent.util.background.BackProcessor;
import org.tctalent.util.background.BackRunner;
import org.tctalent.util.background.IdContext;

@SpringBootTest
class TalentCatalogServiceImplTest {
  @Autowired
  TalentCatalogServiceImpl tcService;

  @Autowired
  AnonymizationService anonymizationService;

  @Autowired
  CandidateMongoRepository anonCandidateRepository;

  @Autowired
  CandidateMapper candidateMapper;

  @BeforeEach
  void setUp() {
  }

  @Test
  void login() {
    try {
      tcService.login();
      assertTrue(tcService.isLoggedIn());
    } catch (RestClientException ex) {
      fail(ex);
    }
  }

  @Test
  void fetchPageOfCandidateDataAsJson() {
    try {
      String pageOfDataAsJson = tcService.fetchPageOfCandidateDataAsJson(0);
      assertNotNull(pageOfDataAsJson);
    } catch (RestClientException ex) {
      fail(ex);
    }
  }

  @Test
  @Transactional
  void loginAndFetchPageOfCandidateData() {
    try {
      tcService.login();
      assertTrue(tcService.isLoggedIn());

      IdentifiableCandidatePage pageOfIdentifiableCandidates = tcService.fetchPageOfIdentifiableCandidateData(0);
      assertNotNull(pageOfIdentifiableCandidates);

      List<CandidateDocument> anonCandidates = pageOfIdentifiableCandidates
          .getContent()
          .stream()
          .map(candidateMapper::anonymize)
          .toList();

      assertNotNull(anonCandidates);
      String collect = anonCandidates
          .stream()
          .map(ca -> ca.getUuid().toString())
          .collect(Collectors.joining(","));
      System.out.println("Received numbers: " + collect);

      anonCandidateRepository.saveAll(anonCandidates);
      for (CandidateDocument candidate : anonCandidateRepository.findAll()) {
        System.out.println(candidate);
      }

    } catch (RestClientException ex) {
      fail(ex);
    }
  }

  @Test
  void loginAndFetchFirstFewPagesOfCandidateData() {
//    try {
//      tcService.login();
//      assertTrue(tcService.isLoggedIn());
//
//      BackRunner<IdContext> backRunner;
//      BackProcessor<IdContext> backProcessor;
//      ThreadPoolTaskScheduler taskScheduler;
//
//      taskScheduler = new ThreadPoolTaskScheduler();
//      taskScheduler.initialize();
//      backRunner = new BackRunner<>();
//      backProcessor = new BackProcessor<>() {
//        @Override
//        public boolean process(IdContext ctx) {
//          long startId = ctx.getLastProcessedId() == null ? 0 : ctx.getLastProcessedId()+1;
//          System.out.println("Processing " + ctx.getNumToProcess() + " ids starting from "
//              + (startId == 0 ? "beginning " : startId) );
//          String pageOfDataAsJson =
//              tcService.fetchPageOfCandidateDataAsJson((int) startId);
//          assertNotNull(pageOfDataAsJson);
//
//          Page<AnonCandidate>
//              anonCandidates = null;
//          try {
//            anonCandidates = anonymizationService.anonymizePage(pageOfDataAsJson);
//          } catch (JsonProcessingException e) {
//            e.printStackTrace();
//            throw new RuntimeException(e);
//          }
//          assertNotNull(anonCandidates);
//          String collect = anonCandidates.stream()
//              .map(ca -> Long.toString(ca.getCandidateNumber()))
//              .collect(Collectors.joining(","));
//          System.out.println("Received numbers: " + collect);
//          long lastProcessed = startId + ctx.getNumToProcess() - 1;
//          ctx.setLastProcessedId(lastProcessed);
//          return lastProcessed+1 >= 50;
//        }
//      };
//
//      ScheduledFuture<?> scheduledFuture =
//          backRunner.start(taskScheduler, backProcessor,
//              new IdContext(null, 1),
//              10);
//
//      Thread.sleep(30000);
//
//    } catch (Exception ex) {
//      fail(ex);
//    }
  }



}
