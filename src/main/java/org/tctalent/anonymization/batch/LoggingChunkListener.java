package org.tctalent.anonymization.batch;

import org.springframework.batch.core.ChunkListener;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.stereotype.Component;

@Component
public class LoggingChunkListener implements ChunkListener {

  @Override
  public void afterChunk(ChunkContext context) {
    System.out.println("Chunk processed successfully. Chunk details: " + context.getStepContext().getStepExecution());
  }

  @Override
  public void afterChunkError(ChunkContext context) {
    System.err.println("An error occurred while processing the chunk: " + context.getStepContext().getStepExecution());
  }
}