package org.tctalent.anonymization.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.tctalent.anonymization.model.Candidate;
import org.tctalent.anonymization.model.IdentifiableCandidate;

/**
 * Copies fields from Candidate where there is a matching field in AnonCandidate
 *
 * @author John Cameron
 */
@Service
@RequiredArgsConstructor
public class AnonymizationServiceImpl implements AnonymizationService{
    private final ObjectMapper mapper;

    @Override
    public Candidate anonymize(IdentifiableCandidate candidate) throws JsonProcessingException {
        String json = mapper.writeValueAsString(candidate);
        return anonymize(json);
    }

    @Override
    public Candidate anonymize(String json) throws JsonProcessingException {
        return mapper.readValue(json, Candidate.class);
    }
}
