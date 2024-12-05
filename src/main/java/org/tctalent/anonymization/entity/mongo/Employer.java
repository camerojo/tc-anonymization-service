package org.tctalent.anonymization.entity.mongo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Employer {
  private Country country;
  private String description;
  private Boolean hasHiredInternationally;
  private String website;
}
