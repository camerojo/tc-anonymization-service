package org.tctalent.anonymization.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;
import org.tctalent.anonymization.entity.db.Candidate;

public interface CandidateRepository extends JpaRepository<Candidate, UUID> {

}
