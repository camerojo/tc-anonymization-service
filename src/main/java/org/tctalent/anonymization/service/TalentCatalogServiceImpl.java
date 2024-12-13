package org.tctalent.anonymization.service;

import static org.springframework.http.MediaType.APPLICATION_JSON;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientException;
import org.tctalent.anonymization.config.properties.TalentCatalogServiceProperties;
import org.tctalent.anonymization.model.IdentifiableCandidatePage;
import org.tctalent.anonymization.request.LoginRequest;
import org.tctalent.anonymization.request.candidate.SavedSearchGetRequest;
import org.tctalent.anonymization.response.JwtAuthenticationResponse;

/**
 * @author John Cameron
 */
@Service
public class TalentCatalogServiceImpl implements TalentCatalogService {
  private final TalentCatalogServiceProperties properties;
  private JwtAuthenticationResponse credentials;

  private final RestClient restClient;
  private final long savedSearchId;

  public TalentCatalogServiceImpl(RestClient.Builder restClientBuilder,
      TalentCatalogServiceProperties properties) {
    this.properties = properties;
    this.restClient = restClientBuilder.baseUrl(properties.getApiUrl()).build();
    this.savedSearchId = properties.getSearchId();
  }

  @Override
  public void login() throws RestClientException {
    LoginRequest request = new LoginRequest();
    request.setUsername(properties.getUsername());
    request.setPassword(properties.getPassword());

    credentials = restClient.post()
        .uri("/auth/login")
        .contentType(APPLICATION_JSON)
        .body(request)
        .retrieve()
        .body(JwtAuthenticationResponse.class);
  }

  @Override
  public String fetchPageOfCandidateDataAsJson(int pageNumber) {
    try {
      SavedSearchGetRequest request = new SavedSearchGetRequest();
      request.setPageSize(100);
      request.setPageNumber(pageNumber);
      return restClient.post()
          .uri("/saved-search-candidate/" + savedSearchId + "/search-paged")
          .contentType(APPLICATION_JSON)
          .header(HttpHeaders.AUTHORIZATION,
              credentials.getTokenType() + " " + credentials.getAccessToken())
          .body(request)
          .retrieve()
          .body(String.class);
    } catch (HttpClientErrorException e) {
      //Check for logged out
      if (e.getStatusCode().isSameCodeAs(HttpStatus.UNAUTHORIZED)) {
        credentials = null;
      }
      throw e;
    }
  }

  @Override
  public IdentifiableCandidatePage fetchPageOfIdentifiableCandidateData(int pageNumber, int pageSize)
      throws RestClientException {
    try {
      SavedSearchGetRequest request = new SavedSearchGetRequest();
      request.setPageSize(pageSize);
      request.setPageNumber(pageNumber);
      return restClient.post()
          .uri("/saved-search-candidate/" + savedSearchId + "/search-paged")
          .contentType(APPLICATION_JSON)
          .header(HttpHeaders.AUTHORIZATION,
              credentials.getTokenType() + " " + credentials.getAccessToken())
          .body(request)
          .retrieve()
          .body(IdentifiableCandidatePage.class);
    } catch (HttpClientErrorException e) {
      //Check for logged out
      if (e.getStatusCode().isSameCodeAs(HttpStatus.UNAUTHORIZED)) {
        credentials = null;
      }
      throw e;
    }
  }

  @Override
  public boolean isLoggedIn() {
    return credentials != null;
  }
}
