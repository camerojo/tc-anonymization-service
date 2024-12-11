package org.tctalent.anonymization.batch;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Configuration properties for batch processing.
 * </p>
 * Example configuration in {@code application.yml}:
 * <pre>
 *  batch:
 *    chunk-size: 100
 *    page-size: 100
 * </pre>
 *
 * @author sadatmalik
 */
@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "batch")
public class BatchProperties {
  private int chunkSize;
  private int pageSize;
}
