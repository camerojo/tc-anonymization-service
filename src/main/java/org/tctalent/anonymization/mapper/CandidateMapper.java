package org.tctalent.anonymization.mapper;

import org.springframework.data.domain.Page;
import org.tctalent.anonymization.entity.CandidateEntity;
import org.tctalent.anonymization.model.Candidate;
import org.tctalent.anonymization.model.CandidatePage;

public class CandidateMapper {

  public static Candidate toModel(CandidateEntity entity) {
    return Candidate.builder()
        .id(entity.getId()) // todo fix this - decide which IDs to use and which mappings to set up
        .gender(entity.getGender()) // todo just for testing, need to update with full mappings
        .status(entity.getStatus())
        .countryId(entity.getCountryId())
        .yearOfArrival(entity.getYearOfArrival())
        .nationalityOldId(entity.getNationalityOldId())
        .unhcrStatus(entity.getUnhcrStatus())
        .maxEducationLevelId(entity.getMaxEducationLevelId())
        .createdDate(entity.getCreatedDate())
        .updatedDate(entity.getUpdatedDate())
        .build();
  }

  public static CandidatePage toCandidatePage(Page<Candidate> page) {
    return CandidatePage.builder()
        .content(page.getContent())
        .totalElements((int)page.getTotalElements())
        .totalPages(page.getTotalPages())
        .size(page.getSize())
        .number(page.getNumber() + 1) // todo update API to start at page 0?
        .build();
  }

}
