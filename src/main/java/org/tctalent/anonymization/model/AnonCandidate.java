package org.tctalent.anonymization.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

/**
 * Model generated from OpenAPI
 * //TODO JC Make this more realistic
 */
@Getter
@Setter
public class AnonCandidate {
    @Id
    Long candidateNumber;
    boolean married;
}
