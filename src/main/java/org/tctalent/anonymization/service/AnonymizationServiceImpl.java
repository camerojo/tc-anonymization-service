package org.tctalent.anonymization.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.tctalent.anonymization.model.AnonCandidate;
import org.tctalent.anonymization.model.Candidate;
import org.tctalent.util.jackson.RestPage;

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

    @Override
    public Page<AnonCandidate> anonymizePage(String json) throws JsonProcessingException {
        //See https://www.baeldung.com/java-deserialize-generic-type-with-jackson
        //See also {@link RestPage} doc for why we can't directly deserialize the standard
        //PageImpl.
        TypeReference<RestPage<AnonCandidate>> typeRef = new TypeReference<>() {};
        return mapper.readValue(json, typeRef);
    }
}
