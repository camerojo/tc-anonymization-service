package org.tctalent.anonymization.entity.mongo;

import lombok.Getter;
import lombok.Setter;
import org.tctalent.anonymization.entity.common.enums.Exam;

@Getter
@Setter
public class CandidateExam {
  private Exam exam;
  private String otherExam;
  private Long year;
  private String notes;
}
