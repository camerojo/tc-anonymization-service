package org.tctalent.anonymization.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientException;
import org.tctalent.anonymization.model.AnonCandidate;
import org.tctalent.server.response.JwtAuthenticationResponse;

@SpringBootTest
class TalentCatalogServiceImplTest {
    TalentCatalogServiceImpl tcService;
    AnonymizationService anonymizationService;

    @BeforeEach
    void setUp() {
        tcService = new TalentCatalogServiceImpl(RestClient.builder());
        anonymizationService = new AnonymizationServiceImpl();
    }

    @Test
    void login() {
        try {
            tcService.login();
            JwtAuthenticationResponse currentCredentials = tcService.getCurrentCredentials();
            assertNotNull(currentCredentials);
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
    void loginAndFetchPageOfCandidateDataAsJson() {
        try {
            tcService.login();
            JwtAuthenticationResponse currentCredentials = tcService.getCurrentCredentials();
            assertNotNull(currentCredentials);

            String pageOfDataAsJson = tcService.fetchPageOfCandidateDataAsJson(0);
            assertNotNull(pageOfDataAsJson);

            Page<AnonCandidate>
                anonCandidates = anonymizationService.anonymizePage(pageOfDataAsJson);
            assertNotNull(anonCandidates);
            String collect = anonCandidates.stream()
                .map(ca -> Long.toString(ca.getCandidateNumber()))
                .collect(Collectors.joining(","));
            System.out.println("Received numbers: " + collect);
        } catch (RestClientException ex) {
            fail(ex);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }



}
