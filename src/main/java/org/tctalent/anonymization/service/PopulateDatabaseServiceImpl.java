package org.tctalent.anonymization.service;

import java.util.List;
import java.util.concurrent.ScheduledFuture;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Page;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.tctalent.anonymization.model.AnonCandidate;
import org.tctalent.server.repository.AnonCandidateRepository;
import org.tctalent.util.background.BackProcessor;
import org.tctalent.util.background.BackRunner;
import org.tctalent.util.background.IdContext;

/**
 * This implementation only supports one populateDatabase at a time.
 * <p/>
 * If {@link #populateDatabase(int)} is called a second time it will cancel the previously
 * scheduled repeating task and clear the database before starting again.
 */
@Getter
@Setter
@RequiredArgsConstructor
@Service
public class PopulateDatabaseServiceImpl implements PopulateDatabaseService {
    private int percentageCpu;
    private ScheduledFuture<?> scheduledFuture;

    private final AnonymizationService anonymizationService;
    private final TalentCatalogService tcService;
    private final TaskScheduler taskScheduler;
    private final AnonCandidateRepository anonCandidateRepository;


    @Override
    public void populateDatabase(int percentageCPU) {
        //Clear database to start
        anonCandidateRepository.deleteAll();

        //Cancel any existing populate tasks (guarding against calling this method twice)
        if (scheduledFuture != null && !scheduledFuture.isDone()) {
            onFailedBuild();
        }

        this.percentageCpu = percentageCPU;

        BackRunner<IdContext> backRunner = new BackRunner<>();
        BackProcessor<IdContext> backProcessor = new BackProcessor<>() {
            @Override
            public boolean process(IdContext idContext) {
                return getDataFromTcServer(idContext);
            }
        };

        scheduledFuture = backRunner.start(taskScheduler, backProcessor,
                new IdContext(null, 1), percentageCpu);
    }

    private boolean getDataFromTcServer(IdContext ctx) {
        int pageNumber = ctx.getLastProcessedId() == null ? 0 : (int) (ctx.getLastProcessedId() + 1);

        System.out.println("Processing page " + pageNumber);

        try {
            if (!tcService.isLoggedIn()) {
              tcService.login();
            }

            String pageOfDataAsJson = tcService.fetchPageOfCandidateDataAsJson(pageNumber);
            Page<AnonCandidate> anonCandidates = anonymizationService.anonymizePage(
                pageOfDataAsJson);
            saveCandidates(anonCandidates.getContent());

            ctx.setLastProcessedId((long) pageNumber);

            return !anonCandidates.hasNext();
        } catch (RestClientException e) {
            //Maybe logged out. Just return. If so, next scheduled task will automatically log in
            return false;
        } catch (Exception e) {

            //TODO JC Otherwise fail the whole run
            onFailedBuild();
            e.printStackTrace();
            return false;
        }
    }

    private void onFailedBuild() {
        //Kill scheduling
        if (scheduledFuture != null && !scheduledFuture.isDone()) {
            scheduledFuture.cancel(true);
        }
        scheduledFuture = null;
        //Clear database
        anonCandidateRepository.deleteAll();
    }

    private void saveCandidates(List<AnonCandidate> content) {
        anonCandidateRepository.saveAll(content);
    }
}
