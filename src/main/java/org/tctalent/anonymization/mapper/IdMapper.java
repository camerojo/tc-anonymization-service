package org.tctalent.anonymization.mapper;

import org.mapstruct.Mapper;
import java.util.UUID;

@Mapper
public interface IdMapper {
  default UUID map(Long value) {
    return value == null ? null : new UUID(0, value); // todo - dummy conversion
  }

  default UUID map(String value) {
    UUID uuid = value == null ? null : new UUID(0, Long.parseLong(value)); // todo - dummy conversion
    return uuid;
  }

  default Long map(UUID value) {
    return value == null ? null : value.getLeastSignificantBits(); // todo - dummy reverse conversion
  }
}
