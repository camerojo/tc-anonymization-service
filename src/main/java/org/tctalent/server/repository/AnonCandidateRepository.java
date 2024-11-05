package org.tctalent.server.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.tctalent.anonymization.model.AnonCandidate;

/**
 * TODO JC Doc
 *
 * @author John Cameron
 */
public interface AnonCandidateRepository  extends MongoRepository<AnonCandidate, String> {

}
