package org.tctalent.anonymization.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.tctalent.anonymization.config.JacksonConfig;
import org.tctalent.anonymization.model.Candidate;
import org.tctalent.anonymization.model.IdentifiableCandidate;

/**
 * Test
 *
 * @author John Cameron
 */
class AnonymizationServiceImplTest {
    AnonymizationService service;

    @BeforeEach
    void setUp() {
        JacksonConfig jacksonConfig = new JacksonConfig();
        ObjectMapper objectMapper = jacksonConfig.objectMapper();

        service = new AnonymizationServiceImpl(objectMapper);
    }

    @Test
    void anonymize() throws JsonProcessingException {

        UUID uuid = UUID.randomUUID();

        IdentifiableCandidate identifiableCandidate = IdentifiableCandidate.builder()
            .id(uuid)
            .name("John Doe")
            .contact("+1-234-567-890")
            .email("johndoe@example.com")
            .address("123 Main St, Springfield, IL")
            .dateOfBirth(LocalDate.parse("1985-06-15"))                           // Date of birth in yyyy-MM-dd format
            .skills(List.of("Java", "Python", "AWS"))
            .experience(5.5f)
            .dateCreated(OffsetDateTime.now())
            .build();

        Candidate candidate = service.anonymize(identifiableCandidate);

        assertEquals(uuid, candidate.getId());
        System.out.println(candidate);
    }
}
