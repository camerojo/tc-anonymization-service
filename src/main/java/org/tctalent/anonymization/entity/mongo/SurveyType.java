package org.tctalent.anonymization.entity.mongo;

import lombok.Getter;
import lombok.Setter;
import org.tctalent.anonymization.entity.common.enums.Status;

@Getter
@Setter
public class SurveyType {
  private String name;
  private Status status;
}
