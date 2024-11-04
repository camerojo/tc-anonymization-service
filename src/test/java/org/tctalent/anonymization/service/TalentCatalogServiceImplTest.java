package org.tctalent.anonymization.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestClient;

class TalentCatalogServiceImplTest {
    TalentCatalogServiceImpl tcService;

    @BeforeEach
    void setUp() {
        tcService = new TalentCatalogServiceImpl(RestClient.builder());
    }

    @Test
    void fetchPageOfCandidateDataAsJson() {
        String pageOfDataAsJson = tcService.fetchPageOfCandidateDataAsJson(0);
        assertNotNull(pageOfDataAsJson);
    }
}
