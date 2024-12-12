package org.tctalent.anonymization.entity.mongo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CandidateLanguage {
  private String isoCode;
  private String name;
  private LanguageLevel writtenLevel;
  private LanguageLevel spokenLevel;
  private String migrationLanguage;

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CandidateLanguage {\n");
    sb.append("    isoCode: ").append(toIndentedString(isoCode)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    writtenLevel: ").append(toIndentedString(writtenLevel)).append("\n");
    sb.append("    spokenLevel: ").append(toIndentedString(spokenLevel)).append("\n");
    sb.append("    migrationLanguage: ").append(toIndentedString(migrationLanguage)).append("\n");
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
