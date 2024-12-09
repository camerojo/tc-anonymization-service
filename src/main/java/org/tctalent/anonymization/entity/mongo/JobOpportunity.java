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

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class JobOpportunity {\n");
    sb.append("    contactUser: ").append(toIndentedString(contactUser)).append("\n");
    sb.append("    country: ").append(toIndentedString(country)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    employer: ").append(toIndentedString(employer)).append("\n");
    sb.append("    employerEntity: ").append(toIndentedString(employerEntity)).append("\n");
    sb.append("    evergreen: ").append(toIndentedString(evergreen)).append("\n");
    sb.append("    exclusionList: ").append(toIndentedString(exclusionList)).append("\n");
    sb.append("    jobSummary: ").append(toIndentedString(jobSummary)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    ownerId: ").append(toIndentedString(ownerId)).append("\n");
    sb.append("    publishedBy: ").append(toIndentedString(publishedBy)).append("\n");
    sb.append("    publishedDate: ").append(toIndentedString(publishedDate)).append("\n");
    sb.append("    stage: ").append(toIndentedString(stage)).append("\n");
    sb.append("    submissionDueDate: ").append(toIndentedString(submissionDueDate)).append("\n");
    sb.append("    submissionList: ").append(toIndentedString(submissionList)).append("\n");
    sb.append("    suggestedList: ").append(toIndentedString(suggestedList)).append("\n");
    sb.append("    suggestedSearches: ").append(toIndentedString(suggestedSearches)).append("\n");
    sb.append("    hiringCommitment: ").append(toIndentedString(hiringCommitment)).append("\n");
    sb.append("    employerWebsite: ").append(toIndentedString(employerWebsite)).append("\n");
    sb.append("    employerHiredInternationally: ").append(toIndentedString(employerHiredInternationally)).append("\n");
    sb.append("    opportunityScore: ").append(toIndentedString(opportunityScore)).append("\n");
    sb.append("    employerDescription: ").append(toIndentedString(employerDescription)).append("\n");
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
