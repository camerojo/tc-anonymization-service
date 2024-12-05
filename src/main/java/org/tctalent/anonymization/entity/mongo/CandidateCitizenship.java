package org.tctalent.anonymization.entity.mongo;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.tctalent.anonymization.entity.common.enums.HasPassport;

@Getter
@Setter
public class CandidateCitizenship {
  private HasPassport hasPassport;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate passportExp;
  private Country nationality;
  private String notes;
}
