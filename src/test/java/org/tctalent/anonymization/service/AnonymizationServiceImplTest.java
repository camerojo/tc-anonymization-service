package org.tctalent.anonymization.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
}
