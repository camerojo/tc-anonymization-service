// Copyright 2009 Cameron Edge Pty Ltd. All rights reserved.
// Reproduction in whole or in part in any form or medium without express
// written permission of Cameron Edge Pty Ltd is strictly prohibited.

package org.tctalent.anonymization.service;

import static org.springframework.http.MediaType.APPLICATION_JSON;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientException;
import org.tctalent.server.request.candidate.SavedSearchGetRequest;

@Service
public class TalentCatalogServiceImpl implements TalentCatalogService {

    private final RestClient restClient;
    private long savedSearchId = 123; //TODO JC Config
    private String apiUrl = "http://localhost:8080/api/admin"; //TODO config

    public TalentCatalogServiceImpl(RestClient.Builder restClientBuilder) {
        this.restClient = restClientBuilder.baseUrl(apiUrl).build();
    }

    @Override
    public String fetchPageOfCandidateDataAsJson(int pageNumber) throws RestClientException {
        SavedSearchGetRequest request = new SavedSearchGetRequest();
        request.setPageSize(100);
        request.setPageNumber(pageNumber);
        return this.restClient.post()
            .uri("/" + savedSearchId + "/searchPaged")
            .contentType(APPLICATION_JSON)
            .body(request)
            .retrieve()
            .body(String.class);
    }
}
