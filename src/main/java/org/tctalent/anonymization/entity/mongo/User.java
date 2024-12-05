package org.tctalent.anonymization.entity.mongo;

import jakarta.validation.Valid;
import java.time.Instant;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.tctalent.anonymization.entity.common.enums.Role;
import org.tctalent.anonymization.entity.common.enums.Status;

@Getter
@Setter
public class User {
  private String username;
  private String firstName;
  private String lastName;
  private String email;
  private Role role;
  private Boolean readOnly;
  private String passwordEnc;
  private Status status;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private Instant lastLogin;
  private String resetToken;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private Instant resetTokenIssuedDate;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private Instant passwordUpdatedDate;
  private Boolean usingMfa;
  private String mfaSecret;
  private User approver;
  private String purpose;

  @Valid
  private List<SearchResponse> sharedSearches;

  @Valid
  private List<@Valid Object> sharedLists;

  @Valid
  private List<@Valid Country> sourceCountries;
  private Boolean jobCreator;
}

