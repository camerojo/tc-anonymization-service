package org.tctalent.anonymization.entity.mongo;

import lombok.Getter;
import lombok.Setter;
import org.tctalent.anonymization.entity.common.enums.YesNoUnsure;

@Getter
@Setter
public class Destination {
  private Country country;
  private YesNoUnsure interest;
  private String notes;

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Destination {\n");
    sb.append("    country: ").append(toIndentedString(country)).append("\n");
    sb.append("    interest: ").append(toIndentedString(interest)).append("\n");
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
