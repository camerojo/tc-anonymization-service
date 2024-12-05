package org.tctalent.anonymization.entity.mongo;


import lombok.Getter;
import lombok.Setter;
import org.tctalent.anonymization.entity.common.enums.EducationType;

@Getter
@Setter
public class CandidateEducation {
  private EducationType educationType;
  private Country country;
  private EducationMajor educationMajor;
  private Integer lengthOfCourseYears;
  private String institution;
  private String courseName;
  private Integer yearCompleted;
  private Boolean incomplete;
}
