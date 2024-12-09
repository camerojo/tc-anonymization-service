package org.tctalent.anonymization.entity.mongo;

import java.time.Instant;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.tctalent.anonymization.entity.common.enums.Status;

@Getter
@Setter
public class TaskAssignment {

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private Instant abandonedDate;
  private String candidateNote;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private Instant completedDate;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private Instant deactivatedDate;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate dueDate;
  private Status status;
  private Task task;

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TaskAssignment {\n");
    sb.append("    abandonedDate: ").append(toIndentedString(abandonedDate)).append("\n");
    sb.append("    candidateNote: ").append(toIndentedString(candidateNote)).append("\n");
    sb.append("    completedDate: ").append(toIndentedString(completedDate)).append("\n");
    sb.append("    deactivatedDate: ").append(toIndentedString(deactivatedDate)).append("\n");
    sb.append("    dueDate: ").append(toIndentedString(dueDate)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    task: ").append(toIndentedString(task)).append("\n");
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
