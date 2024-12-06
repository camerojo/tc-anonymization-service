package org.tctalent.anonymization.batch;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.lang.NonNull;
import org.tctalent.anonymization.entity.db.Candidate;
import org.tctalent.anonymization.entity.mongo.CandidateDocument;
import org.tctalent.anonymization.mapper.CandidateMapper;


@Slf4j
@RequiredArgsConstructor
public class CandidateItemProcessor implements
    ItemProcessor<Candidate, CandidateDocument> {

  private final CandidateMapper candidateMapper;

  @Override
  public CandidateDocument process(@NonNull final Candidate entity) {
    return candidateMapper.toDocument(entity);
  }

}