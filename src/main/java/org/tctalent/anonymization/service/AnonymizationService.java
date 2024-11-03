package org.tctalent.anonymization.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.tctalent.anonymization.model.AnonCandidate;
import org.tctalent.anonymization.model.Candidate;

/**
 * Performs anonymization
 *
 * @author John Cameron
 */
public interface AnonymizationService {

    /**
     * Converts full candidate into an anonymized version of it.
     * @param candidate Full candidate data
     * @return Copy of data removing personal information
     * @throws JsonProcessingException if the data couldn't be converted
     */
    AnonCandidate anonymize(Candidate candidate) throws JsonProcessingException;

    /**
     * Converts full candidate represented as JSON String into an anonymized version of it.
     * @param json Full candidate data
     * @return Copy of data removing personal information
     * @throws JsonProcessingException if the data couldn't be converted
     */
    AnonCandidate anonymize(String json) throws JsonProcessingException;
}
