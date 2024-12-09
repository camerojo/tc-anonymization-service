package org.tctalent.anonymization.batch;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.ChunkListener;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class LoggingChunkListener implements ChunkListener {

  @Override
  public void afterChunk(ChunkContext context) {
    // todo LogBuilder
    System.out.println("Chunk processed successfully. Chunk details: " + context.getStepContext().getStepExecution());
    long readCount = context.getStepContext().getStepExecution().getReadCount();
    long writeCount = context.getStepContext().getStepExecution().getWriteCount();
    System.out.println("Total items read/written so far: " + readCount + "r, " + writeCount + "w");
  }

  @Override
  public void afterChunkError(ChunkContext context) {
    // todo LogBuilder
    System.err.println("An error occurred while processing the chunk: " + context.getStepContext().getStepExecution());
  }
}