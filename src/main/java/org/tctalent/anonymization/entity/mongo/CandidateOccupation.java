package org.tctalent.anonymization.entity.mongo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CandidateOccupation {
  private Occupation occupation;
  private Integer yearsExperience;
  private Boolean topCandidate;
  private String migrationOccupation;
}
