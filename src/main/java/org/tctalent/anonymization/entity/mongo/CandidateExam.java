package org.tctalent.anonymization.entity.mongo;

import lombok.Getter;
import lombok.Setter;
import org.tctalent.anonymization.entity.common.enums.Exam;

@Getter
@Setter
public class CandidateExam {
  private Exam exam;
  private String otherExam;
  private Long year;
  private String notes;

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CandidateExam {\n");
    sb.append("    exam: ").append(toIndentedString(exam)).append("\n");
    sb.append("    otherExam: ").append(toIndentedString(otherExam)).append("\n");
    sb.append("    year: ").append(toIndentedString(year)).append("\n");
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
