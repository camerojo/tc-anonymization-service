package org.tctalent.anonymization.entity.mongo;

import jakarta.validation.Valid;
import java.time.Instant;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Transient;
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

  @Transient // todo don't serialize to mongo until List schema is added to OpenApi
  @Valid
  private List<@Valid Object> sharedLists;

  @Valid
  private List<@Valid Country> sourceCountries;
  private Boolean jobCreator;

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class User {\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    role: ").append(toIndentedString(role)).append("\n");
    sb.append("    readOnly: ").append(toIndentedString(readOnly)).append("\n");
    sb.append("    passwordEnc: ").append(toIndentedString(passwordEnc)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    lastLogin: ").append(toIndentedString(lastLogin)).append("\n");
    sb.append("    resetToken: ").append(toIndentedString(resetToken)).append("\n");
    sb.append("    resetTokenIssuedDate: ").append(toIndentedString(resetTokenIssuedDate)).append("\n");
    sb.append("    passwordUpdatedDate: ").append(toIndentedString(passwordUpdatedDate)).append("\n");
    sb.append("    usingMfa: ").append(toIndentedString(usingMfa)).append("\n");
    sb.append("    mfaSecret: ").append(toIndentedString(mfaSecret)).append("\n");
    sb.append("    approver: ").append(toIndentedString(approver)).append("\n");
    sb.append("    purpose: ").append(toIndentedString(purpose)).append("\n");
    sb.append("    sharedSearches: ").append(toIndentedString(sharedSearches)).append("\n");
    sb.append("    sharedLists: ").append(toIndentedString(sharedLists)).append("\n");
    sb.append("    sourceCountries: ").append(toIndentedString(sourceCountries)).append("\n");
    sb.append("    jobCreator: ").append(toIndentedString(jobCreator)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

