// Copyright 2008 Orc Software AB. All rights reserved.
// Reproduction in whole or in part in any form or medium without express
// written permission of Orc Software AB is strictly prohibited.

package org.tctalent.anonymization.service;

import org.springframework.web.client.RestClientException;

/**
 * Access the main Talent Catalog Server
 *
 * @author John Cameron
 */
public interface TalentCatalogService {

   /**
    * Returns the given page number of candidate data.
    * <p/>
    * Uses a default TC search request.
    * @param pageNumber Page number
    * @return Page of candidates encoded as JSON strings
    * @throws RestClientException if errors are returned (eg unauthorized)
    */
   String fetchPageOfCandidateDataAsJson(int pageNumber) throws RestClientException;
}
