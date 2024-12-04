package org.tctalent.anonymization.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.data.domain.Page;
import org.tctalent.anonymization.model.Candidate;
import org.tctalent.anonymization.model.CandidatePage;

@Mapper(uses = IdMapper.class)
public interface CandidateMapper {

  @Mapping(source = "id", target = "id")
  Candidate toModel(org.tctalent.anonymization.entity.db.Candidate entity);

  CandidatePage toCandidatePage(Page<Candidate> page);
}
