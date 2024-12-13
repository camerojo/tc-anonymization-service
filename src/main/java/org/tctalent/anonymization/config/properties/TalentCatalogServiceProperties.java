package org.tctalent.anonymization.config.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Configuration properties for {@link org.tctalent.anonymization.service.TalentCatalogService}.
 * </p>
 * Example configuration in {@code application.yml}:
 * <pre>
 *  tc-service:
 *    api-url: http://localhost:8080/api/admin
 *    search-id: 4672
 *    username: appAnonDatabaseService
 *    password: 12345678
 * </pre>
 *
 * @author sadatmalik
 */
@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "tc-service")
public class TalentCatalogServiceProperties {
  private String apiUrl;
  private long searchId;
  private String username;
  private String password;
}
