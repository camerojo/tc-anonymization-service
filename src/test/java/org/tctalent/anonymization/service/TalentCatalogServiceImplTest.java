package org.tctalent.anonymization.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientException;

@SpringBootTest
class TalentCatalogServiceImplTest {
    TalentCatalogServiceImpl tcService;

    @BeforeEach
    void setUp() {
        tcService = new TalentCatalogServiceImpl(RestClient.builder());
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
}
