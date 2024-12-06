package org.tctalent.anonymization.batch;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class JobCompletionNotificationListener implements JobExecutionListener {

  @Override
  public void afterJob(JobExecution jobExecution) {
    if (BatchStatus.COMPLETED.equals(jobExecution.getStatus())) {
      // todo use LogBuilder
      log.info("!!!! Batch job COMPLETED !!!!");
    }
  }

}
