package org.tctalent.anonymization.request.candidate.exam;

import lombok.Getter;
import lombok.Setter;
import org.tctalent.anonymization.entity.common.enums.Exam;
import org.tctalent.anonymization.request.PagedSearchRequest;

@Setter
@Getter
public class SearchCandidateExamRequest extends PagedSearchRequest {

    private Exam exam;

    private String otherExam;

    private String score;

    private Long year;

    private String notes;

    // Getters and Setters

}
