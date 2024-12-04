package org.tctalent.anonymization.service;

import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.tctalent.anonymization.mapper.CandidateMapper;
import org.tctalent.anonymization.model.Candidate;
import org.tctalent.anonymization.model.CandidatePage;
import org.tctalent.anonymization.repository.CandidateRepository;

@Service
@RequiredArgsConstructor
public class CandidateServiceImpl implements CandidateService {

  private final CandidateRepository candidateRepository;
  private final CandidateMapper candidateMapper;

  @Override
  public CandidatePage findAll(Pageable pageable) {
    Page<Candidate> candidatePage =  candidateRepository
        .findAll(pageable)
        .map(candidateMapper::toModel);

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
