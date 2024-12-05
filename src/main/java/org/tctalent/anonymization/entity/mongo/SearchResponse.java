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
}
