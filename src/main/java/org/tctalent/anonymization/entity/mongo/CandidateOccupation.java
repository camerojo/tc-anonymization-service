package org.tctalent.anonymization.entity.mongo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CandidateOccupation {
  private Occupation occupation;
  private Integer yearsExperience;
  private Boolean topCandidate;
  private String migrationOccupation;

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CandidateOccupation {\n");
    sb.append("    occupation: ").append(toIndentedString(occupation)).append("\n");
    sb.append("    yearsExperience: ").append(toIndentedString(yearsExperience)).append("\n");
    sb.append("    topCandidate: ").append(toIndentedString(topCandidate)).append("\n");
    sb.append("    migrationOccupation: ").append(toIndentedString(migrationOccupation)).append("\n");
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
