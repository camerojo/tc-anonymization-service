package org.tctalent.anonymization.entity.mongo;

import lombok.Getter;
import lombok.Setter;
import org.tctalent.anonymization.model.Country;
import org.tctalent.anonymization.model.YesNoUnsure;

@Getter
@Setter
public class Destination {
  private Country country;
  private YesNoUnsure interest;
  private String notes;
}
