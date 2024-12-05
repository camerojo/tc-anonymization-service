package org.tctalent.anonymization.entity.mongo;

import lombok.Getter;
import lombok.Setter;
import org.tctalent.anonymization.model.Status;

@Getter
@Setter
public class EducationMajor {
  private Long id;
  private String iscedCode;
  private String name;
  private Status status;
}
