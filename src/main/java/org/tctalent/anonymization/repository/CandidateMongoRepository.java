package org.tctalent.anonymization.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.tctalent.anonymization.entity.mongo.CandidateDocument;

@Repository
public interface CandidateMongoRepository extends MongoRepository<CandidateDocument, String> {
  List<CandidateDocument> findById(Long id);
}
