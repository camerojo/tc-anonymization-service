package org.tctalent.anonymization.exception;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for the {@link RestApiReaderException} class.
 *
 * @author sadatmalik
 */
class RestApiReaderExceptionTest {

  @Test
  @DisplayName("Test constructor with message")
  void testConstructorWithMessage() {
    String message = "Test message";
    RestApiReaderException exception = new RestApiReaderException(message);

    assertEquals("rest_api_read_failed", exception.getErrorCode());
    assertEquals(message, exception.getMessage());
  }

  @Test
  @DisplayName("Test constructor with message and cause")
  void testConstructorWithMessageAndCause() {
    String message = "Test message";
    Throwable cause = new RuntimeException("Cause");
    RestApiReaderException exception = new RestApiReaderException(message, cause);

    assertEquals("rest_api_read_failed", exception.getErrorCode());
    assertEquals(message, exception.getMessage());
    assertEquals(cause, exception.getCause());
  }

  @Test
  @DisplayName("Test constructor with code, message and cause")
  void testConstructorWithCodeMessageAndCause() {
    String code = "custom_code";
    String message = "Test message";
    Throwable cause = new RuntimeException("Cause");
    RestApiReaderException exception = new RestApiReaderException(code, message, cause);

    assertEquals(code, exception.getErrorCode());
    assertEquals(message, exception.getMessage());
    assertEquals(cause, exception.getCause());
  }
}