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

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Dependant {\n");
    sb.append("    relation: ").append(toIndentedString(relation)).append("\n");
    sb.append("    relationOther: ").append(toIndentedString(relationOther)).append("\n");
    sb.append("    dob: ").append(toIndentedString(dob)).append("\n");
    sb.append("    gender: ").append(toIndentedString(gender)).append("\n");
    sb.append("    registered: ").append(toIndentedString(registered)).append("\n");
    sb.append("    registeredNotes: ").append(toIndentedString(registeredNotes)).append("\n");
    sb.append("    healthConcern: ").append(toIndentedString(healthConcern)).append("\n");
    sb.append("    healthNotes: ").append(toIndentedString(healthNotes)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
