package org.tctalent.anonymization.entity.mongo;

import lombok.Getter;
import lombok.Setter;
import org.tctalent.anonymization.model.Status;

@Getter
@Setter
public class Occupation {
  private String isco08Code;
  private String name;
  private Status status;
}
