package org.tctalent.anonymization.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.tctalent.anonymization.model.AnonCandidate;
import org.tctalent.anonymization.model.Candidate;

/**
 * Copies fields from Candidate where there is a matching field in AnonCandidate
 *
 * @author John Cameron
 */
@Service
public class AnonymizationServiceImpl implements AnonymizationService{
    private final ObjectMapper mapper = new ObjectMapper()
        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    @Override
    public AnonCandidate anonymize(Candidate candidate) throws JsonProcessingException {
        String json = mapper.writeValueAsString(candidate);
        return anonymize(json);
    }

    @Override
    public AnonCandidate anonymize(String json) throws JsonProcessingException {
        return mapper.readValue(json, AnonCandidate.class);
    }
}
