package org.tctalent.anonymization.entity.mongo;

import java.time.LocalDate;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.tctalent.anonymization.entity.common.enums.Gender;
import org.tctalent.anonymization.entity.common.enums.SearchType;

@Getter
@Setter
public class SearchResponse {
  private String simpleQueryString;
  private String statuses;
  private Gender gender;
  private String occupationIds;
  private Integer minYrs;
  private Integer maxYrs;
  private String partnerIds;
  private String nationalityIds;
  private SearchType nationalitySearchType;
  private String countryIds;
  private SearchType countrySearchType;
  private String surveyTypeIds;
  private Long exclusionListId;
  private String listAllIds;
  private SearchType listAllSearchType;
  private String listAnyIds;
  private SearchType listAnySearchType;
  private Integer englishMinWrittenLevel;
  private Integer englishMinSpokenLevel;
  private Long otherLanguageId;
  private Integer otherMinWrittenLevel;
  private Integer otherMinSpokenLevel;
  private String unhcrStatuses;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate lastModifiedFrom;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate lastModifiedTo;
  private Integer minAge;
  private Integer maxAge;
  private Integer minEducationLevel;
  private String educationMajorIds;
  private Boolean miniIntakeCompleted;
  private Boolean fullIntakeCompleted;
  private String regoReferrerParam;
  private Boolean reviewable;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate fromDate;
  private UUID id;

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SearchResponse {\n");
    sb.append("    simpleQueryString: ").append(toIndentedString(simpleQueryString)).append("\n");
    sb.append("    statuses: ").append(toIndentedString(statuses)).append("\n");
    sb.append("    gender: ").append(toIndentedString(gender)).append("\n");
    sb.append("    occupationIds: ").append(toIndentedString(occupationIds)).append("\n");
    sb.append("    minYrs: ").append(toIndentedString(minYrs)).append("\n");
    sb.append("    maxYrs: ").append(toIndentedString(maxYrs)).append("\n");
    sb.append("    partnerIds: ").append(toIndentedString(partnerIds)).append("\n");
    sb.append("    nationalityIds: ").append(toIndentedString(nationalityIds)).append("\n");
    sb.append("    nationalitySearchType: ").append(toIndentedString(nationalitySearchType)).append("\n");
    sb.append("    countryIds: ").append(toIndentedString(countryIds)).append("\n");
    sb.append("    countrySearchType: ").append(toIndentedString(countrySearchType)).append("\n");
    sb.append("    surveyTypeIds: ").append(toIndentedString(surveyTypeIds)).append("\n");
    sb.append("    exclusionListId: ").append(toIndentedString(exclusionListId)).append("\n");
    sb.append("    listAllIds: ").append(toIndentedString(listAllIds)).append("\n");
    sb.append("    listAllSearchType: ").append(toIndentedString(listAllSearchType)).append("\n");
    sb.append("    listAnyIds: ").append(toIndentedString(listAnyIds)).append("\n");
    sb.append("    listAnySearchType: ").append(toIndentedString(listAnySearchType)).append("\n");
    sb.append("    englishMinWrittenLevel: ").append(toIndentedString(englishMinWrittenLevel)).append("\n");
    sb.append("    englishMinSpokenLevel: ").append(toIndentedString(englishMinSpokenLevel)).append("\n");
    sb.append("    otherLanguageId: ").append(toIndentedString(otherLanguageId)).append("\n");
    sb.append("    otherMinWrittenLevel: ").append(toIndentedString(otherMinWrittenLevel)).append("\n");
    sb.append("    otherMinSpokenLevel: ").append(toIndentedString(otherMinSpokenLevel)).append("\n");
    sb.append("    unhcrStatuses: ").append(toIndentedString(unhcrStatuses)).append("\n");
    sb.append("    lastModifiedFrom: ").append(toIndentedString(lastModifiedFrom)).append("\n");
    sb.append("    lastModifiedTo: ").append(toIndentedString(lastModifiedTo)).append("\n");
    sb.append("    minAge: ").append(toIndentedString(minAge)).append("\n");
    sb.append("    maxAge: ").append(toIndentedString(maxAge)).append("\n");
    sb.append("    minEducationLevel: ").append(toIndentedString(minEducationLevel)).append("\n");
    sb.append("    educationMajorIds: ").append(toIndentedString(educationMajorIds)).append("\n");
    sb.append("    miniIntakeCompleted: ").append(toIndentedString(miniIntakeCompleted)).append("\n");
    sb.append("    fullIntakeCompleted: ").append(toIndentedString(fullIntakeCompleted)).append("\n");
    sb.append("    regoReferrerParam: ").append(toIndentedString(regoReferrerParam)).append("\n");
    sb.append("    reviewable: ").append(toIndentedString(reviewable)).append("\n");
    sb.append("    fromDate: ").append(toIndentedString(fromDate)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
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
