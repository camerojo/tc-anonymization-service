package org.tctalent.anonymization.entity.mongo;

import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.tctalent.anonymization.entity.common.enums.OtherVisas;
import org.tctalent.anonymization.entity.common.enums.TBBEligibilityAssessment;
import org.tctalent.anonymization.entity.common.enums.VisaEligibility;
import org.tctalent.anonymization.entity.common.enums.YesNo;

@Getter
@Setter
public class CandidateVisaJobCheck {
  private JobOpportunity jobOpp;
  private YesNo interest;
  private String interestNotes;
  private YesNo qualification;
  private String qualificationNotes;
  private Occupation occupation;
  private String occupationNotes;
  private YesNo salaryTsmit;
  private YesNo regional;
  private YesNo eligible494;
  private String eligible494Notes;
  private YesNo eligible186;
  private String eligible186Notes;
  private OtherVisas eligibleOther;
  private String eligibleOtherNotes;
  private VisaEligibility putForward;
  private TBBEligibilityAssessment tbbEligibility;
  private String notes;
  private String relevantWorkExp;
  private String ageRequirement;
  private String preferredPathways;
  private String ineligiblePathways;
  private String eligiblePathways;
  private String occupationCategory;
  private String occupationSubCategory;
  private YesNo englishThreshold;

  @Valid
  private List<Long> languagesRequired;
  private YesNo languagesThresholdMet;
  private String languagesThresholdNotes;
}
