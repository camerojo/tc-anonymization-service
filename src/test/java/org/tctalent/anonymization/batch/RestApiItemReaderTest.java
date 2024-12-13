package org.tctalent.anonymization.batch;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.tctalent.anonymization.exception.RestApiReaderException;
import org.tctalent.anonymization.model.IdentifiableCandidate;
import org.tctalent.anonymization.model.IdentifiableCandidatePage;
import org.tctalent.anonymization.service.TalentCatalogService;

/**
 * Unit tests for the {@link RestApiItemReader} class.
 *
 * @author sadatmalik
 */
class RestApiItemReaderTest {

  @Mock
  private TalentCatalogService talentCatalogService;

  @InjectMocks
  private RestApiItemReader restApiItemReader;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  @DisplayName("Test read")
  void testRead() throws Exception {
    IdentifiableCandidate candidate1 = new IdentifiableCandidate();
    IdentifiableCandidate candidate2 = new IdentifiableCandidate();
    IdentifiableCandidatePage page = new IdentifiableCandidatePage();
    page.setContent(List.of(candidate1, candidate2));
    page.setTotalPages(1);

    when(talentCatalogService
        .fetchPageOfIdentifiableCandidateData(0))
        .thenReturn(page);

    IdentifiableCandidate result1 = restApiItemReader.read();
    IdentifiableCandidate result2 = restApiItemReader.read();
    IdentifiableCandidate result3 = restApiItemReader.read();

    assertEquals(candidate1, result1);
    assertEquals(candidate2, result2);
    assertNull(result3);
  }

  @Test
  @DisplayName("Test read fetches next batch when batch iterator is null")
  void testReadFetchesNextBatchWhenBatchIteratorIsNull() throws Exception {
    IdentifiableCandidate candidate = new IdentifiableCandidate();
    IdentifiableCandidatePage page = new IdentifiableCandidatePage();
    page.setContent(List.of(candidate));
    page.setTotalPages(1);

    when(talentCatalogService
        .isLoggedIn())
        .thenReturn(true);

    when(talentCatalogService
        .fetchPageOfIdentifiableCandidateData(0))
        .thenReturn(page);

    IdentifiableCandidate result = restApiItemReader.read();

    assertNotNull(result, "The returned candidate should not be null");
    assertEquals(candidate, result, "The returned candidate should match the fetched batch");
    verify(talentCatalogService).fetchPageOfIdentifiableCandidateData(0);
  }

  @Test
  @DisplayName("Test read fetches next batch when batch iterator is empty")
  void testFetchNextBatchCallsLoginWhenNotLoggedIn() {
    when(talentCatalogService
        .isLoggedIn())
        .thenReturn(false);

    assertThrows(
        RestApiReaderException.class,
        () -> restApiItemReader.read(),
        "Should throw an exception if login fails or fetch is interrupted");

    verify(talentCatalogService).login();
  }

  @Test
  @DisplayName("Test read fetches next batch and handles null response from API")
  void testFetchNextBatchHandlesNullResponseFromApi() {
    when(talentCatalogService
        .isLoggedIn())
        .thenReturn(true);

    when(talentCatalogService
        .fetchPageOfIdentifiableCandidateData(0))
        .thenReturn(null);

    assertThrows(
        RestApiReaderException.class,
        () -> restApiItemReader.read(),
        "Should throw an exception if the API response is null");
  }

  @Test
  @DisplayName("Test read fetches next batch and handles null content in response from API")
  void testFetchNextBatchHandlesEmptyBatch() throws Exception {
    IdentifiableCandidatePage page = new IdentifiableCandidatePage();
    page.setContent(List.of());
    page.setTotalPages(1);

    when(talentCatalogService
        .isLoggedIn())
        .thenReturn(true);

    when(talentCatalogService
        .fetchPageOfIdentifiableCandidateData(0))
        .thenReturn(page);

    IdentifiableCandidate result = restApiItemReader.read();

    assertNull(result, "The returned candidate should be null when the batch is empty");
  }

  @Test
  @DisplayName("Test read throws exception for unhandled errors")
  void testReadThrowsExceptionForUnhandledErrors() {
    when(talentCatalogService
        .isLoggedIn())
        .thenThrow(new RuntimeException("Unexpected error"));

    Exception exception = assertThrows(
        RestApiReaderException.class,
        () -> restApiItemReader.read(),
        "Should wrap unhandled exceptions in RestApiReaderException");

    assertTrue(exception.getMessage().contains("Failed to read IdentifiableCandidate"));
  }

  @Test
  @DisplayName("Test read with exception")
  void testReadWithException() {
    when(talentCatalogService
        .fetchPageOfIdentifiableCandidateData(0))
        .thenThrow(new RestApiReaderException("Error"));

    assertThrows(
        RestApiReaderException.class,
        () -> restApiItemReader.read(),
        "Should throw an exception if on API fetch error"
    );
  }

}