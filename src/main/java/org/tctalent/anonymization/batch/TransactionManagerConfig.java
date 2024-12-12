package org.tctalent.anonymization.batch;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

/**
 * Configuration class defining the {@link DataSourceTransactionManager} bean, which manages
 * transactions for the application by coordinating with the provided {@link DataSource}.
 * </p>
 * Used for transaction management across the batch process.
 *
 * @author sadatmalik
 */
@Configuration
public class TransactionManagerConfig {

  @Bean
  public DataSourceTransactionManager transactionManager(DataSource dataSource) {
    return new DataSourceTransactionManager(dataSource);
  }
}
