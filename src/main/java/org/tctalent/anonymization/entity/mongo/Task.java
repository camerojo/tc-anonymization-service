package org.tctalent.anonymization.entity.mongo;

import java.time.Instant;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

@Getter
@Setter
public class Task {
  private Boolean admin;
  private Integer daysToComplete;
  private String description;
  private String helpLink;
  private String displayName;
  private String name;
  private Boolean optional;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private Instant createdDate;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private Instant updatedDate;
}
