package org.tctalent.anonymization.batch;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;
import org.tctalent.anonymization.logging.LogBuilder;

/**
 * Listener for handling job completion notifications in the batch process.
 * </p>
 * Implements {@link JobExecutionListener} providing a hook for further actions upon job completion
 * if needed.
 *
 * @author sadatmalik
 */
@Slf4j
@Component
public class JobCompletionNotificationListener implements JobExecutionListener {

  @Override
  public void afterJob(JobExecution jobExecution) {
    if (BatchStatus.COMPLETED.equals(jobExecution.getStatus())) {
      LogBuilder.builder(log)
          .action("Batch completion")
          .message("Batch job has finished successfully.")
          .logInfo();
    }
  }

}
