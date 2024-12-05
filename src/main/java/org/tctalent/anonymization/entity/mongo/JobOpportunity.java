package org.tctalent.anonymization.entity.mongo;

import jakarta.validation.Valid;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.tctalent.anonymization.entity.common.enums.JobOpportunityStage;

@Getter
@Setter
public class JobOpportunity {
  private User contactUser;
  private Country country;
  private String description;
  private String employer;
  private Employer employerEntity;
  private Boolean evergreen;
  private Object exclusionList;
  private String jobSummary;
  private String name;
  private String ownerId;
  private User publishedBy;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private Instant publishedDate;
  private JobOpportunityStage stage;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate submissionDueDate;
  private Object submissionList;
  private Object suggestedList;

  @Valid
  private List<SearchResponse> suggestedSearches;
  private Long hiringCommitment;
  private String employerWebsite;
  private Boolean employerHiredInternationally;
  private String opportunityScore;
  private String employerDescription;
}
