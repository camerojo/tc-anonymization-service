package org.tctalent.anonymization.entity.mongo;

import lombok.Getter;
import lombok.Setter;
import org.tctalent.anonymization.entity.common.enums.Status;


@Getter
@Setter
public class EducationMajor {
  private Long id;
  private String iscedCode;
  private String name;
  private Status status;

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EducationMajor {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    iscedCode: ").append(toIndentedString(iscedCode)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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
