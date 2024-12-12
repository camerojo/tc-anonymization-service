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

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CandidateCitizenship {\n");
    sb.append("    hasPassport: ").append(toIndentedString(hasPassport)).append("\n");
    sb.append("    passportExp: ").append(toIndentedString(passportExp)).append("\n");
    sb.append("    nationality: ").append(toIndentedString(nationality)).append("\n");
    sb.append("    notes: ").append(toIndentedString(notes)).append("\n");
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
