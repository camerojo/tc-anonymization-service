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
}
