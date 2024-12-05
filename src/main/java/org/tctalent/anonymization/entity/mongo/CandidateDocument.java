package org.tctalent.anonymization.entity.mongo;

import jakarta.validation.Valid;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;
import org.tctalent.anonymization.entity.common.enums.CandidateStatus;
import org.tctalent.anonymization.entity.common.enums.DocumentStatus;
import org.tctalent.anonymization.entity.common.enums.Gender;
import org.tctalent.anonymization.entity.common.enums.IeltsStatus;
import org.tctalent.anonymization.entity.common.enums.IntRecruitReason;
import org.tctalent.anonymization.entity.common.enums.LeftHomeReason;
import org.tctalent.anonymization.entity.common.enums.MaritalStatus;
import org.tctalent.anonymization.entity.common.enums.NotRegisteredStatus;
import org.tctalent.anonymization.entity.common.enums.ResidenceStatus;
import org.tctalent.anonymization.entity.common.enums.UnhcrStatus;
import org.tctalent.anonymization.entity.common.enums.VaccinationStatus;
import org.tctalent.anonymization.entity.common.enums.WorkPermit;
import org.tctalent.anonymization.entity.common.enums.YesNo;
import org.tctalent.anonymization.entity.common.enums.YesNoUnemployedOther;
import org.tctalent.anonymization.entity.common.enums.YesNoUnsure;
import org.tctalent.anonymization.entity.common.enums.AvailImmediateReason;

@Getter
@Setter
@Document(collection = "candidates")
public class CandidateDocument {

  //  todo @Id
  private String id;
  //  todo private UUID id;

  private String candidateNumber;
  private String additionalInfo;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate asylumYear;
  private YesNoUnsure arrestImprison;
  private String arrestImprisonNotes;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate availDate;
  private YesNo availImmediate;
  private String availImmediateJobOps;
  private AvailImmediateReason availImmediateReason;
  private String availImmediateNotes;
  private Country birthCountry;

  @Valid
  private List<@Valid CandidateCertification> candidateCertifications;

  @Valid
  private List<@Valid CandidateCitizenship> candidateCitizenships;

  @Valid
  private List<@Valid Dependant> candidateDependants;

  @Valid
  private List<@Valid Destination> candidateDestinations;

  @Valid
  private List<@Valid CandidateEducation> candidateEducations;

  @Valid
  private List<@Valid CandidateExam> candidateExams;

  @Valid
  private List<@Valid CandidateJobExperience> candidateJobExperiences;

  @Valid
  private List<@Valid CandidateLanguage> candidateLanguages;

  // todo sm tested up to here - remove this comment after writing unit tests - placeholder
  private String candidateMessage;

  @Valid
  private List<@Valid CandidateNote> candidateNotes;

  @Valid
  private List<@Valid CandidateOccupation> candidateOccupations;

  @Transient // todo don't serialize to mongo until List schema is added to OpenApi
  @Valid
  private List<@Valid Object> candidateSavedLists;

  @Valid
  private List<@Valid CandidateSkill> candidateSkills;

  @Valid
  private List<@Valid CandidateVisaCheck> candidateVisaChecks;
  private YesNo canDrive;
  private String city;
  private YesNo conflict;
  private String conflictNotes;
  private Boolean contactConsentPartners;
  private Boolean contactConsentRegistration;
  private Country country;
  private YesNo covidVaccinated;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate covidVaccinatedDate;
  private String covidVaccineName;
  private String covidVaccineNotes;
  private VaccinationStatus covidVaccinatedStatus;
  private YesNoUnsure crimeConvict;
  private String crimeConvictNotes;
  private YesNo destLimit;
  private String destLimitNotes;
  private DocumentStatus drivingLicense;
  private Country drivingLicenseCountry;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate drivingLicenseExp;
  private String englishAssessment;
  private String englishAssessmentScoreIelts;
  private YesNo familyMove;
  private String familyMoveNotes;
  private String frenchAssessment;
  private Long frenchAssessmentScoreNclc;
  private User fullIntakeCompletedBy;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private Instant fullIntakeCompletedDate;
  private Gender gender;
  private YesNo healthIssues;
  private String healthIssuesNotes;
  private String homeLocation;
  private String hostChallenges;
  private YesNo hostEntryLegally;
  private String hostEntryLegallyNotes;
  private Integer hostEntryYear;
  private String hostEntryYearNotes;
  private Float ieltsScore;

  @Valid
  private List<IntRecruitReason> intRecruitReasons;
  private String intRecruitOther;
  private YesNoUnsure intRecruitRural;
  private String intRecruitRuralNotes;
  private String leftHomeNotes;

  @Valid
  private List<LeftHomeReason> leftHomeReasons;
  private MaritalStatus maritalStatus;
  private String maritalStatusNotes;
  private EducationLevel maxEducationLevel;
  private String mediaWillingness;
  private EducationMajor migrationEducationMajor;
  private String migrationNationality;
  private YesNo militaryService;
  private YesNoUnsure militaryWanted;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate militaryStart;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate militaryEnd;
  private String militaryNotes;
  private User miniIntakeCompletedBy;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private Instant miniIntakeCompletedDate;
  private YesNo monitoringEvaluationConsent;
  private Country nationality;
  private Long numberDependants;
  private YesNoUnsure partnerRegistered;

  @Valid
  private List<Long> partnerCitizenship;
  private EducationLevel partnerEduLevel;
  private String partnerEduLevelNotes;
  private YesNo partnerEnglish;
  private LanguageLevel partnerEnglishLevel;
  private IeltsStatus partnerIelts;
  private String partnerIeltsScore;
  private Long partnerIeltsYr;
  private Occupation partnerOccupation;
  private String partnerOccupationNotes;
  private ResidenceStatus residenceStatus;
  private String residenceStatusNotes;
  private YesNoUnsure returnedHome;
  private String returnedHomeReason;
  private String returnedHomeReasonNo;
  private YesNoUnsure returnHomeSafe;
  private YesNoUnsure returnHomeFuture;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate returnHomeWhen;
  private YesNo resettleThird;
  private String resettleThirdStatus;
  private String shareableNotes;
  private String state;
  private CandidateStatus status;
  private SurveyType surveyType;
  private String surveyComment;

  @Valid
  private List<@Valid TaskAssignment> taskAssignments;
  private YesNo unhcrConsent;
  private String unhcrNotes;
  private NotRegisteredStatus unhcrNotRegStatus;
  private YesNoUnsure unhcrRegistered;
  private UnhcrStatus unhcrStatus;
  private String unrwaNotes;
  private NotRegisteredStatus unrwaNotRegStatus;
  private YesNoUnsure unrwaRegistered;
  private YesNoUnsure visaIssues;
  private String visaIssuesNotes;
  private YesNoUnsure visaReject;
  private String visaRejectNotes;
  private YesNo workAbroad;
  private String workAbroadNotes;
  private YesNoUnemployedOther workDesired;
  private String workDesiredNotes;
  private WorkPermit workPermit;
  private YesNoUnsure workPermitDesired;
  private String workPermitDesiredNotes;
  private Integer yearOfArrival;
  private Integer yearOfBirth;
  private User createdBy;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private Instant createdDate;
  private User updatedBy;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private Instant updatedDate;

  // todo equals, hadhcode, tostring
}

