package org.tctalent.anonymization.batch;

import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.ItemWriteListener;
import org.springframework.batch.item.Chunk;
import org.springframework.stereotype.Component;
import org.tctalent.anonymization.entity.mongo.CandidateDocument;

@Slf4j
@Component
public class LoggingItemWriterListener implements ItemWriteListener<CandidateDocument> {


  @Override
  public void onWriteError(Exception exception, Chunk<? extends CandidateDocument> items) {
    // Log the items that failed to write - todo LogBuilder
    log.error("An error occurred while writing items.", exception);

    String itemDetails = items.getItems().stream()
        .map(Object::toString)
        .collect(Collectors.joining(", "));
    log.error("Failed to write items: {}", itemDetails);  // todo LogBuilder
  }

}
