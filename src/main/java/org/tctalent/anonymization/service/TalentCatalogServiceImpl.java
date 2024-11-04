// Copyright 2009 Cameron Edge Pty Ltd. All rights reserved.
// Reproduction in whole or in part in any form or medium without express
// written permission of Cameron Edge Pty Ltd is strictly prohibited.

package org.tctalent.anonymization.service;

import static org.springframework.http.MediaType.APPLICATION_JSON;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientException;
import org.tctalent.server.request.LoginRequest;
import org.tctalent.server.request.candidate.SavedSearchGetRequest;
import org.tctalent.server.response.JwtAuthenticationResponse;

@Service
public class TalentCatalogServiceImpl implements TalentCatalogService {
    private JwtAuthenticationResponse credentials;

    private final RestClient restClient;
    private long savedSearchId = 22; //TODO JC Config - need to pass in real Search id
    private String apiUrl = "http://localhost:8080/api/admin"; //TODO config

    public TalentCatalogServiceImpl(RestClient.Builder restClientBuilder) {
        this.restClient = restClientBuilder.baseUrl(apiUrl).build();
    }

    @Override
    public void login() throws RestClientException {
        LoginRequest request = new LoginRequest();
        request.setUsername("appAnonDatabaseService");
        request.setPassword("12345678");

        credentials = this.restClient.post()
            .uri("/auth/login")
            .contentType(APPLICATION_JSON)
            .body(request)
            .retrieve()
            .body(JwtAuthenticationResponse.class);
    }

    @Override
    public String fetchPageOfCandidateDataAsJson(int pageNumber) throws RestClientException {
        SavedSearchGetRequest request = new SavedSearchGetRequest();
        request.setPageSize(100);
        request.setPageNumber(pageNumber);
        return this.restClient.post()
            .uri("/saved-search-candidate/" + savedSearchId + "/search-paged")
            .contentType(APPLICATION_JSON)
            .header(HttpHeaders.AUTHORIZATION,
                credentials.getTokenType() + " " + credentials.getAccessToken())
            .body(request)
            .retrieve()
            .body(String.class);
    }

    @Override
    public JwtAuthenticationResponse getCurrentCredentials() {
        return credentials;
    }
}
