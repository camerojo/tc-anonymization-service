package org.tctalent.anonymization.entity.mongo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CandidateLanguage {
  private String isoCode;
  private String name;
  private LanguageLevel writtenLevel;
  private LanguageLevel spokenLevel;
  private String migrationLanguage;
}
