package org.tctalent.anonymization.entity.mongo;

import lombok.Getter;
import lombok.Setter;
import org.tctalent.anonymization.entity.common.enums.NoteType;

@Getter
@Setter
public class CandidateNote {
  private String title;
  private String comment;
  private NoteType noteType;
}

