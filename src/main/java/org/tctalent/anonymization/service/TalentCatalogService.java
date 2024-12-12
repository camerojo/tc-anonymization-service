package org.tctalent.anonymization.service;

import org.springframework.web.client.RestClientException;
import org.tctalent.anonymization.model.IdentifiableCandidatePage;

/**
 * Access the main Talent Catalog Server
 *
 * @author John Cameron
 */
public interface TalentCatalogService {

  /**
   * True if we are currently logged in to the TC.
   * @return True if logged in
   */
  boolean isLoggedIn();

  /**
   * Logs in to TC server with app password
   * @throws RestClientException If login failed
   */
  void login() throws RestClientException;

  /**
   * Returns the given page number of candidate data.
   * <p/>
   * Uses a default TC search request.
   * @param pageNumber Page number
   * @return Page of candidates encoded as JSON strings
   * @throws RestClientException if errors are returned (eg unauthorized)
   */
  String fetchPageOfCandidateDataAsJson(int pageNumber) throws RestClientException;

  /**
   * Returns the given page number of identifiable candidate data.
   * <p/>
   * Uses a default TC search request.
   * @param pageNumber Page number
   * @return CandidatePage Page of candidates
   * @throws RestClientException if errors are returned (eg unauthorized)
   */
  IdentifiableCandidatePage fetchPageOfIdentifiableCandidateData(int pageNumber) throws RestClientException;
}
