package org.tctalent.anonymization.batch;

import java.util.Iterator;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.tctalent.anonymization.exception.RestApiReaderException;
import org.tctalent.anonymization.model.IdentifiableCandidate;
import org.tctalent.anonymization.model.IdentifiableCandidatePage;
import org.tctalent.anonymization.service.TalentCatalogService;

/**
 * An {@link ItemReader} implementation that reads data from the {@link TalentCatalogService},
 * fetching paginated batches of {@link IdentifiableCandidate} objects.
 *
 * @author sadatmalik
 */
@Component
@RequiredArgsConstructor
@Qualifier("restApiItemReader")
public class RestApiItemReader implements ItemReader<IdentifiableCandidate> {

  private final TalentCatalogService talentCatalogService;

  private int currentPage = 0;
  private int totalPages = 1; // Initialise with 1 to start fetching
  private Iterator<IdentifiableCandidate> batchIterator;

  @Override
  public IdentifiableCandidate read() throws RestApiReaderException {
    try {
      if (batchIterator == null || !batchIterator.hasNext()) {
        fetchNextBatch();
      }
      return batchIterator != null && batchIterator.hasNext() ? batchIterator.next() : null;
    } catch (RestApiReaderException e) {
      throw e;
    } catch (Exception e) {
      throw new RestApiReaderException("Failed to read IdentifiableCandidate from REST API", e);
    }
  }

  private void fetchNextBatch() {
    if (!talentCatalogService.isLoggedIn()) {
      talentCatalogService.login();
    }
    if (currentPage < totalPages) {
      IdentifiableCandidatePage page = talentCatalogService.fetchPageOfIdentifiableCandidateData(currentPage);

      if (page == null || page.getContent() == null) {
        throw new RestApiReaderException("Received null or invalid response from the REST API");
      }

      List<IdentifiableCandidate> currentBatch = page.getContent();
      totalPages = page.getTotalPages();
      batchIterator = currentBatch.iterator();
      currentPage++;
    }
  }
}
