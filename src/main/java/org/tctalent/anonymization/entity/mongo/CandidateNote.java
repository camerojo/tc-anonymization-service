package org.tctalent.anonymization.entity.mongo;

import lombok.Getter;
import lombok.Setter;
import org.tctalent.anonymization.entity.common.enums.NoteType;

@Getter
@Setter
public class CandidateNote {
  private String title;
  private String comment;
  private NoteType noteType;

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CandidateNote {\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    comment: ").append(toIndentedString(comment)).append("\n");
    sb.append("    noteType: ").append(toIndentedString(noteType)).append("\n");
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

