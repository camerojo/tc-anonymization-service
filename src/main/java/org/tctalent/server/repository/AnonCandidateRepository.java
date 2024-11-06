package org.tctalent.server.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.tctalent.anonymization.model.AnonCandidate;

/**
 * See
 * <a href="https://www.mongodb.com/docs/manual/tutorial/install-mongodb-on-os-x/">
 *     Installing MongoDB on Mac</a>
 *
 * @author John Cameron
 */
public interface AnonCandidateRepository  extends MongoRepository<AnonCandidate, String> {

}
