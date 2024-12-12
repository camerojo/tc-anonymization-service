package org.tctalent.anonymization.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.data.domain.Page;
import org.tctalent.anonymization.model.Candidate;
import org.tctalent.anonymization.model.CandidatePage;
import org.tctalent.anonymization.model.IdentifiableCandidate;
import org.tctalent.anonymization.entity.mongo.CandidateDocument;

@Mapper(uses = {
    IdMapper.class,
    DateTimeMapper.class
})
public interface CandidateMapper {

  // Mongo to Open API:
  Candidate toCandidateModel(CandidateDocument document);
  CandidatePage toCandidateModelPage(Page<Candidate> page);

  // TC entity to Mongo
  @Mapping(source = "id", target = "uuid") // todo sm this mocks a uuid based on the id - remove it when uuid's are sent from tc
  @Mapping(source = "createdDate", target = "createdDate")
  CandidateDocument anonymize(org.tctalent.anonymization.entity.db.Candidate entity);

  // TC api to Mongo
  @Mapping(source = "id", target = "uuid") // todo sm this mocks a uuid based on the id - remove it when uuid's are sent from tc
  CandidateDocument anonymize(IdentifiableCandidate identifiableCandidate);
}
