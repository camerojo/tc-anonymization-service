package org.tctalent.anonymization.entity.mongo;

import lombok.Getter;
import lombok.Setter;
import org.tctalent.anonymization.entity.common.enums.EducationType;
import org.tctalent.anonymization.entity.common.enums.Status;

@Getter
@Setter
public class EducationLevel {
  private Integer level;
  private Status status;
  private EducationType educationType;

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EducationLevel {\n");
    sb.append("    level: ").append(toIndentedString(level)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    educationType: ").append(toIndentedString(educationType)).append("\n");
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
