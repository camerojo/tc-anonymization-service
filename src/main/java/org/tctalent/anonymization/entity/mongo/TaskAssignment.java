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
}
