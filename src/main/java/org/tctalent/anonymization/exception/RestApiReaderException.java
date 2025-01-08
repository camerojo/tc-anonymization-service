package org.tctalent.anonymization.exception;

public class RestApiReaderException extends ServiceException {

  private static final String REST_API_READER_EXCEPTION_CODE = "rest_api_read_failed";

  public RestApiReaderException(String code, String message, Throwable cause) {
    super(code, message, cause);
  }

  public RestApiReaderException(String message, Throwable cause) {
    this(REST_API_READER_EXCEPTION_CODE, message, cause);
  }

  public RestApiReaderException(String message) {
    super(REST_API_READER_EXCEPTION_CODE, message);
  }

}
