package org.tctalent.anonymization.entity.mongo;

import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.tctalent.anonymization.entity.common.enums.DocumentStatus;
import org.tctalent.anonymization.entity.common.enums.FamilyRelations;
import org.tctalent.anonymization.entity.common.enums.RiskLevel;
import org.tctalent.anonymization.entity.common.enums.YesNo;
import org.tctalent.anonymization.entity.common.enums.YesNoUnsure;

@Getter
@Setter
public class CandidateVisaCheck {
  private Country country;
  private YesNo protection;
  private String protectionGrounds;
  private YesNo englishThreshold;
  private String englishThresholdNotes;
  private YesNo healthAssessment;
  private String healthAssessmentNotes;
  private YesNo characterAssessment;
  private String characterAssessmentNotes;
  private YesNo securityRisk;
  private String securityRiskNotes;
  private RiskLevel overallRisk;
  private String overallRiskNotes;
  private DocumentStatus validTravelDocs;
  private String validTravelDocsNotes;
  private YesNoUnsure pathwayAssessment;
  private String pathwayAssessmentNotes;
  private FamilyRelations destinationFamily;
  private String destinationFamilyLocation;

  @Valid
  private List<@Valid CandidateVisaJobCheck> candidateVisaJobChecks;

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CandidateVisaCheck {\n");
    sb.append("    country: ").append(toIndentedString(country)).append("\n");
    sb.append("    protection: ").append(toIndentedString(protection)).append("\n");
    sb.append("    protectionGrounds: ").append(toIndentedString(protectionGrounds)).append("\n");
    sb.append("    englishThreshold: ").append(toIndentedString(englishThreshold)).append("\n");
    sb.append("    englishThresholdNotes: ").append(toIndentedString(englishThresholdNotes)).append("\n");
    sb.append("    healthAssessment: ").append(toIndentedString(healthAssessment)).append("\n");
    sb.append("    healthAssessmentNotes: ").append(toIndentedString(healthAssessmentNotes)).append("\n");
    sb.append("    characterAssessment: ").append(toIndentedString(characterAssessment)).append("\n");
    sb.append("    characterAssessmentNotes: ").append(toIndentedString(characterAssessmentNotes)).append("\n");
    sb.append("    securityRisk: ").append(toIndentedString(securityRisk)).append("\n");
    sb.append("    securityRiskNotes: ").append(toIndentedString(securityRiskNotes)).append("\n");
    sb.append("    overallRisk: ").append(toIndentedString(overallRisk)).append("\n");
    sb.append("    overallRiskNotes: ").append(toIndentedString(overallRiskNotes)).append("\n");
    sb.append("    validTravelDocs: ").append(toIndentedString(validTravelDocs)).append("\n");
    sb.append("    validTravelDocsNotes: ").append(toIndentedString(validTravelDocsNotes)).append("\n");
    sb.append("    pathwayAssessment: ").append(toIndentedString(pathwayAssessment)).append("\n");
    sb.append("    pathwayAssessmentNotes: ").append(toIndentedString(pathwayAssessmentNotes)).append("\n");
    sb.append("    destinationFamily: ").append(toIndentedString(destinationFamily)).append("\n");
    sb.append("    destinationFamilyLocation: ").append(toIndentedString(destinationFamilyLocation)).append("\n");
    sb.append("    candidateVisaJobChecks: ").append(toIndentedString(candidateVisaJobChecks)).append("\n");
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
