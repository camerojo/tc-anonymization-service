package org.tctalent.anonymization.batch;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.ChunkListener;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.stereotype.Component;
import org.tctalent.anonymization.logging.LogBuilder;

/**
 * Listener that implements {@link ChunkListener} to provide logging for successful chunk
 * processing and errors that occur during chunk execution.
 *
 * @author sadatmalik
 */
@Slf4j
@Component
public class LoggingChunkListener implements ChunkListener {

  @Override
  public void afterChunk(ChunkContext context) {
    LogBuilder.builder(log)
        .action("Chunk processed successfully")
        .message("Chunk details:" + context.getStepContext().getStepExecution())
        .logInfo();
  }

  @Override
  public void afterChunkError(ChunkContext context) {
    LogBuilder.builder(log)
        .action("Error processing chunk")
        .message("Chunk details:" + context.getStepContext().getStepExecution())
        .logInfo();
  }
}