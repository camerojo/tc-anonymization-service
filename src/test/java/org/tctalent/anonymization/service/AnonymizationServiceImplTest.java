package org.tctalent.anonymization.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.tctalent.anonymization.model.AnonCandidate;
import org.tctalent.anonymization.model.Candidate;

/**
 * Test
 *
 * @author John Cameron
 */
class AnonymizationServiceImplTest {
    AnonymizationService service;

    @BeforeEach
    void setUp() {
        service = new AnonymizationServiceImpl();
    }

    @Test
    void anonymize() throws JsonProcessingException {
        Candidate candidate = new Candidate(12L, "Johnny", true);

        AnonCandidate anonCandidate = service.anonymize(candidate);

        assertEquals(12L, anonCandidate.getCandidateNumber());
        assertTrue(anonCandidate.isMarried());
    }

    @Test
    void anonymizePage() throws JsonProcessingException {
        Candidate candidate = new Candidate(12L, "Johnny", true);
        List<Candidate> content = Collections.singletonList(candidate);
        PageImpl<Candidate> pageOfCandidates = new PageImpl<>(
            content,
            PageRequest.of(0, 10, Sort.unsorted()),
            1
        );
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(pageOfCandidates);

        Page<AnonCandidate> pageDeserialized = service.anonymizePage(json);
        assertEquals(pageOfCandidates.getTotalElements(), pageDeserialized.getTotalElements());

        List<AnonCandidate> anonCandidates = pageDeserialized.getContent();
        assertEquals(1, anonCandidates.size());
        assertEquals(12L, anonCandidates.get(0).getCandidateNumber());
        assertTrue(anonCandidates.get(0).isMarried());

    }
}
