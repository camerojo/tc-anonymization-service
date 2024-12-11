package org.tctalent.anonymization.batch;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.ItemReadListener;
import org.springframework.stereotype.Component;
import org.tctalent.anonymization.entity.db.Candidate;

/**
 * Listener that implements {@link ItemReadListener} to provide logging for errors that
 * occur while reading individual items.
 *
 * @author sadatmalik
 */
@Slf4j
@Component
public class LoggingItemReaderListener implements ItemReadListener<Candidate> {

  @Override
  public void onReadError(Exception exception) {
    // Log details about the error - todo LogBuilder
    log.error("An error occurred while reading an item.", exception);
  }

}
