package org.tctalent.anonymization.entity.mongo;


import lombok.Getter;
import lombok.Setter;

// todo sm placeholder replace this when List schema is ready
@Getter
@Setter
public class ModelList {

  private String fileJdName;

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ModelList {\n");
    sb.append("    fileJdName: ").append(toIndentedString(fileJdName)).append("\n");
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
