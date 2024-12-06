package org.tctalent.anonymization.batch;

import java.util.Collections;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.data.RepositoryItemReader;
import org.springframework.batch.item.data.builder.RepositoryItemReaderBuilder;
import org.springframework.batch.item.data.builder.RepositoryItemWriterBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.tctalent.anonymization.entity.db.Candidate;
import org.tctalent.anonymization.entity.mongo.CandidateDocument;
import org.tctalent.anonymization.mapper.CandidateMapper;
import org.tctalent.anonymization.repository.CandidateMongoRepository;
import org.tctalent.anonymization.repository.CandidateRepository;

@Configuration
public class BatchConfig {

  @Bean
  public Job candidateMigrationJob(JobRepository jobRepository, Step candidateMigrationStep,
      JobCompletionNotificationListener listener) {

    return new JobBuilder("candidateMigrationJob", jobRepository)
        .listener(listener)
        .start(candidateMigrationStep)
        .build();
  }

  @Bean
  public Step candidateMigrationStep(JobRepository jobRepository,
      DataSourceTransactionManager transactionManager,
      ItemReader<Candidate> jpaItemReader,
      ItemProcessor<Candidate, CandidateDocument> processor,
      ItemWriter<CandidateDocument> mongoItemWriter,
      LoggingChunkListener loggingChunkListener) {

    return new StepBuilder("candidateMigrationStep", jobRepository)
        .<Candidate, CandidateDocument>chunk(100, transactionManager)
        .reader(jpaItemReader)
        .processor(processor)
        .writer(mongoItemWriter)
        .listener(loggingChunkListener)
        .build();
  }

  @Bean
  public ItemReader<Candidate> jpaItemReader(CandidateRepository candidateRepository) {
    return new RepositoryItemReaderBuilder<Candidate>()
        .name("candidateJpaRepositoryReader")
        .repository(candidateRepository)
        .methodName("findAll")
        .pageSize(100)
        .arguments(Collections.emptyList())
        .sorts(Collections.singletonMap("id", Sort.Direction.ASC))
        .build();
  }

  @Bean
  public CandidateItemProcessor processor(CandidateMapper mapper) {
    return new CandidateItemProcessor(mapper);
  }

  @Bean
  public ItemWriter<CandidateDocument> mongoItemWriter(CandidateMongoRepository candidateRepository) {
    return new RepositoryItemWriterBuilder<CandidateDocument>()
        .repository(candidateRepository)
        .methodName("save") // todo Use "saveAll" to batch persist documents - errors
        .build();
      }

}
