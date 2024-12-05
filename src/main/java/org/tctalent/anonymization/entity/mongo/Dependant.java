package org.tctalent.anonymization.entity.mongo;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.tctalent.anonymization.entity.common.enums.Gender;
import org.tctalent.anonymization.entity.common.enums.Registration;
import org.tctalent.anonymization.entity.common.enums.YesNo;
import org.tctalent.anonymization.entity.common.enums.DependantRelations;

@Getter
@Setter
public class Dependant {
  private DependantRelations relation;
  private String relationOther;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate dob;
  private Gender gender;
  private Registration registered;
  private String registeredNotes;
  private YesNo healthConcern;
  private String healthNotes;
}
