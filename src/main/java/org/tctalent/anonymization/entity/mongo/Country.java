package org.tctalent.anonymization.entity.mongo;

import lombok.Getter;
import lombok.Setter;
import org.tctalent.anonymization.model.Status;

@Getter
@Setter
public class Country {
  private String isoCode;
  private String name;
  private Status status;
}
