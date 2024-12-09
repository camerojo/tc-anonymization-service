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

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CandidateEducation {\n");
    sb.append("    educationType: ").append(toIndentedString(educationType)).append("\n");
    sb.append("    country: ").append(toIndentedString(country)).append("\n");
    sb.append("    educationMajor: ").append(toIndentedString(educationMajor)).append("\n");
    sb.append("    lengthOfCourseYears: ").append(toIndentedString(lengthOfCourseYears)).append("\n");
    sb.append("    institution: ").append(toIndentedString(institution)).append("\n");
    sb.append("    courseName: ").append(toIndentedString(courseName)).append("\n");
    sb.append("    yearCompleted: ").append(toIndentedString(yearCompleted)).append("\n");
    sb.append("    incomplete: ").append(toIndentedString(incomplete)).append("\n");
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
