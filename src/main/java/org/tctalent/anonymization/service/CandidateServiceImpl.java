package org.tctalent.anonymization.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.tctalent.anonymization.mapper.CandidateMapper;
import org.tctalent.anonymization.model.Candidate;
import org.tctalent.anonymization.model.CandidatePage;
import org.tctalent.anonymization.entity.mongo.CandidateDocument;
import org.tctalent.anonymization.repository.CandidateMongoRepository;
import org.tctalent.anonymization.repository.CandidateRepository;

@Service
@RequiredArgsConstructor
public class CandidateServiceImpl implements CandidateService {

  private final CandidateRepository candidateRepository;
  private final CandidateMongoRepository candidateMongoRepository;
  private final CandidateMapper candidateMapper;

  @Override
  public CandidatePage findAll(Pageable pageable) {
    List<CandidateDocument> documents = new ArrayList<>();
    Page<Candidate> candidatePage =  candidateRepository
        .findAll(pageable)
        .map(candidate -> {
          // todo remove - map mongo docs - just for testing
          CandidateDocument candidateDocument = candidateMapper.toDocument(candidate);
          documents.add(candidateDocument);
          return candidateMapper.toModel(candidate);
        });

    // todo remove - save mongo docs - just for testing
    candidateMongoRepository.saveAll(documents);
    return candidateMapper.toCandidatePage(candidatePage);
  }

  @Override
  public Candidate findById(UUID id) {
    return candidateRepository
        .findById(id)
        .map(candidateMapper::toModel)
        .orElseThrow(() -> new RuntimeException("Candidate not found")); // todo better exceptions
  }

}
