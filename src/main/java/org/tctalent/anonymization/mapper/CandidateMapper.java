package org.tctalent.anonymization.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.data.domain.Page;
import org.tctalent.anonymization.model.Candidate;
import org.tctalent.anonymization.model.CandidatePage;
import org.tctalent.anonymization.entity.mongo.CandidateDocument;

@Mapper(uses = {
    IdMapper.class,
    DateTimeMapper.class
})
public interface CandidateMapper {

  @Mapping(source = "id", target = "id")
  Candidate toModel(org.tctalent.anonymization.entity.db.Candidate entity);

  Candidate toModel(CandidateDocument document);

  CandidatePage toCandidatePage(Page<Candidate> page);

  @Mapping(source = "id", target = "id")
  @Mapping(source = "createdDate", target = "createdDate")
  CandidateDocument toDocument(org.tctalent.anonymization.entity.db.Candidate entity);
}
