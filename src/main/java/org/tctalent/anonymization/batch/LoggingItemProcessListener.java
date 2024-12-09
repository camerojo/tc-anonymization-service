package org.tctalent.anonymization.batch;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.ItemProcessListener;
import org.springframework.stereotype.Component;
import org.tctalent.anonymization.entity.db.Candidate;
import org.tctalent.anonymization.entity.mongo.CandidateDocument;

@Slf4j
@Component
public class LoggingItemProcessListener implements ItemProcessListener<Candidate, CandidateDocument> {

  @Override
  public void onProcessError(Candidate item, Exception e) {
    // Log the item that failed to process - todo LogBuilder
    log.error("An error occurred while processing item.", e);
    log.error("Failed to process item: {}", item.toString());  // todo LogBuilder
  }
}
