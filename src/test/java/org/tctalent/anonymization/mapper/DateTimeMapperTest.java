package org.tctalent.anonymization.mapper;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

/**
 * Unit tests for the {@link DateTimeMapper} class.
 *
 * @author sadatmalik
 */
class DateTimeMapperTest {

  private DateTimeMapper dateTimeMapper;

  @BeforeEach
  void setUp() {
    dateTimeMapper = Mappers.getMapper(DateTimeMapper.class);
  }

  @Test
  @DisplayName("Test instant to offset date time mapping")
  void testToOffsetDateTime() {
    Instant instant = Instant.parse("2023-01-01T00:00:00Z");
    OffsetDateTime offsetDateTime = dateTimeMapper.toOffsetDateTime(instant);

    assertNotNull(offsetDateTime);
    assertEquals(instant, offsetDateTime.toInstant());
    assertEquals(ZoneOffset.UTC, offsetDateTime.getOffset());
  }

  @Test
  @DisplayName("Test instant to offset date time mapping with null")
  void testToOffsetDateTime_Null() {
    OffsetDateTime offsetDateTime = dateTimeMapper.toOffsetDateTime(null);

    assertNull(offsetDateTime);
  }

  @Test
  @DisplayName("Test offset date time to instant mapping")
  void testToInstant() {
    OffsetDateTime offsetDateTime = OffsetDateTime.parse("2024-12-13T00:00:00Z");
    Instant instant = dateTimeMapper.toInstant(offsetDateTime);

    assertNotNull(instant);
    assertEquals(offsetDateTime.toInstant(), instant);
  }

  @Test
  @DisplayName("Test offset date time to instant mapping with null")
  void testToInstant_Null() {
    Instant instant = dateTimeMapper.toInstant(null);

    assertNull(instant);
  }
}
