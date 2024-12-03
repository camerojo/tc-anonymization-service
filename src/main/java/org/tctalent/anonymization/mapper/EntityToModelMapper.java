package org.tctalent.anonymization.mapper;

import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;
//import org.tctalent.anonymization.entity.CandidateEntity;
import org.tctalent.anonymization.model.Candidate;
import org.tctalent.anonymization.model.CandidatePage;

@Mapper
public interface EntityToModelMapper {

//  Candidate toModel(CandidateEntity entity);

  CandidatePage toCandidatePage(Page<Candidate> page);
}
